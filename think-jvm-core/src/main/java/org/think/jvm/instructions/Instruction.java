package org.think.jvm.instructions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.Solt;
import org.think.jvm.rtad.Thread;
import org.think.jvm.rtad.heap.Method;

/**
 * 指令接口
 * @see org.apache.bcel.generic.Instruction
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Instruction {
    protected static final Logger log = LoggerFactory.getLogger(Instruction.class);

    public void accept(org.think.jvm.Visitor visitor){
        //log.debug(this+".accept("+visitor+")");
    }

    public void execute(org.think.jvm.Visitor visitor){
        log.debug(visitor.getFrame().getMethod().getClazz().javaName()+"."+visitor.getFrame().getMethod().getName()+" execute");
    }


    public void invokeMethod(Frame invokerFrame, Method method){
        Thread thread = invokerFrame.getThread();
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(newFrame);
        int argSlotSlot = method.getArgSlotcount();
        if(argSlotSlot > 0) {
            for (int i = argSlotSlot - 1; i >= 0; i--) {
                Solt solt = invokerFrame.getStack().popSolt();
                newFrame.getLocalVars().setSolt(i, solt);
            }
        }
        if(method.getAccessFlags().isNative() && "registerNatives".equals(method.getName())){
            thread.popFrame();
        }
    }

//    @Override
//    public String toString() {
//        return this;
//    }
}
