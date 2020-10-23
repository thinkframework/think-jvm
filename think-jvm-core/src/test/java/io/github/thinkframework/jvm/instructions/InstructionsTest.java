package io.github.thinkframework.jvm.instructions;

import io.github.thinkframework.jvm.classfile.ClassFileTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.thinkframework.jvm.ExecutionVisitor;
import io.github.thinkframework.jvm.classfile.ClassFile;
import io.github.thinkframework.jvm.classfile.ClassFileMethod;
import io.github.thinkframework.jvm.rtad.Frame;
import io.github.thinkframework.jvm.rtad.Solt;
import io.github.thinkframework.jvm.rtad.Thread;
import io.github.thinkframework.jvm.rtad.heap.ArrayObject;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ClazzLoader;
import io.github.thinkframework.jvm.rtad.heap.Method;

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

        Thread thread = new Thread();
        Frame frame = thread.newFrame(clazz.getMainMethod());
        thread.pushFrame(frame);
        loop(thread);

    }


    public void interpret(Method method,String[] args) {
        Thread thread = new Thread();
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

    public void loop(Thread thread) {
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
