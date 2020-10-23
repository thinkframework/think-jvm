package org.think.jvm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.InstructionFactory;
import org.think.jvm.rtad.*;
import org.think.jvm.rtad.Thread;
import org.think.jvm.rtad.heap.ArrayObject;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ClazzLoader;
import org.think.jvm.rtad.heap.Method;

import java.util.Stack;

/**
 * @author lixiaobin
 * @since 2017/3/30
 */
public class Interpreter {
    Log log = LogFactory.getLog(getClass());
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
            debug(frame);
            }catch (Exception e){
                debug(frame);
                log.error("",e);
                break;
            }
        }

    }

    private void debug(Frame frame){
        debugstack(frame);
        debuglocalVars(frame);
    }
    public void debugstack(Frame frame){
        String s="stack:";
        OperandStack localVars = frame.getStack();
        Stack<Solt> solts = localVars.getSolts();
        if(solts != null){
            for(int i = 0; i<solts.size();i++){
                s+="["+i+"]="+solts.get(i)+",";
            }
        }
        log.debug(s);
    }

    public void debuglocalVars(Frame frame){
        String s="localVars:";
        LocalVars localVars = frame.getLocalVars();
        Stack<Solt> solts = localVars.getSolts();
        if(solts != null) {
            for(int i = 0; i<solts.size();i++){
                s+="["+i+"]="+solts.get(i)+",";
            }
        }
        log.debug(s);
    }
}
