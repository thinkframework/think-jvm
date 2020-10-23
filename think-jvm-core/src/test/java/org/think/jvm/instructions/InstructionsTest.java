package org.think.jvm.instructions;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.think.jvm.ExecutionVisitor;
import org.think.jvm.classfile.ClassFile;
import org.think.jvm.classfile.ClassFileMethod;
import org.think.jvm.classfile.ClassFileTest;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.Solt;
import org.think.jvm.rtad.Thread;
import org.think.jvm.rtad.heap.ArrayObject;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ClazzLoader;
import org.think.jvm.rtad.heap.Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * @author lixiaobin
 * @since 2017/3/29
 */
public class InstructionsTest {
    protected static final Logger log = LoggerFactory.getLogger(InstructionsTest.class);
    @Test
    public void test() throws IOException{
        InputStream inputStream = ClassFileTest.class.getClassLoader().getResourceAsStream("classes/book/ch05/ClassFileTest.class");
        ClassFile classFile =new ClassFile(inputStream);
        assertTrue(inputStream.read(new byte[1]) == -1);
        ClassFileMethod[] classFileMethods = classFile.getClassFileMethods();
        for(ClassFileMethod classFileMethod : classFileMethods){
            byte[] bytes = classFileMethod.getCode();
            for(byte _byte : bytes){
                try {
                    log.debug("{}",InstructionFactory.newInstruction(_byte));
                }catch (Exception e){
                    log.error(e.getMessage(),e);
                }
            }
        }
    }

    @Test
    public void test2() throws IOException{

        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
        InputStream inputStream = new FileInputStream(new File(path+File.separator+"classes/GaussTest.class"));
        ClassFile classFile = new ClassFile(inputStream);
        Clazz clazz = new Clazz(classFile);

        org.think.jvm.rtad.Thread thread = new org.think.jvm.rtad.Thread();
        Frame frame = thread.newFrame(clazz.getMainMethod());
        thread.pushFrame(frame);
        loop(thread);

    }


    public void interpret(Method method,String[] args) {
        org.think.jvm.rtad.Thread thread = new org.think.jvm.rtad.Thread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);
        ClazzLoader clazzLoader = frame.getMethod().getClazz().getClazzLoader();
        Object value = createArgsArray(clazzLoader,args);
        frame.getLocalVars().setRef(0,value);
        loop(thread);
    }

    public Object createArgsArray(ClazzLoader clazzLoader,String[] args){
        Clazz stringClass =clazzLoader.loadClass("java/lang/String");
        ArrayObject arrayObject = stringClass.ArrayClass().newArray(args.length);
        for(int i=0;i<args.length;i++){
            arrayObject.setRef(i,args[i]);
        }
        return arrayObject;
    }
    public void invokeMethod(Frame invokerFrame, Method method){
        Thread thread = invokerFrame.getThread();
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(invokerFrame);
        int argSlotSlot = 0;
        for(int i=argSlotSlot;i>=0;i--){
            Solt solt = invokerFrame.getStack().popSolt();
            newFrame.getLocalVars().setSolt(i,solt);
        }
    }

    public void loop(org.think.jvm.rtad.Thread thread) {
        while(!thread.getStack().empty()) {
            Frame frame = null;
            try{
                frame = thread.currentFrame();
                ExecutionVisitor visitor = new ExecutionVisitor(frame);
                int pc = frame.getNextPC();
                thread.setPC(pc);

                visitor.reset(frame.getMethod().getCode(), pc);
                //计算指令
                int opcode = visitor.readUInt8();
                Instruction inst = InstructionFactory.newInstruction(opcode);
                //解析指令
                inst.accept(visitor);
                frame.setNextPC(visitor.getPc());
                //执行指令
                inst.execute(visitor);
            }catch (Exception e){
                log.error("",e);
                break;
            }
        }

    }
}
