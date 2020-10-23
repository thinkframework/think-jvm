package org.think.jvm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.think.jvm.exceptions.VMException;
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

    private static Interpreter instance;
    private Interpreter(){

    }

    public static Interpreter getInstance(){
        if(instance == null){
            instance = new Interpreter();
        }
        return instance;
    }

    public void interpret(Thread thread) {
        loop(thread);
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
            }catch (VMException e){
                log.error("虚拟机异常",e);
                break;
            }
        }

    }

    /**
     * 调试信息
     * @param frame
     */
    private void debug(Frame frame){
        debugstack(frame);
        debuglocalVars(frame);
    }

    private void debugstack(Frame frame){
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

    private void debuglocalVars(Frame frame){
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
