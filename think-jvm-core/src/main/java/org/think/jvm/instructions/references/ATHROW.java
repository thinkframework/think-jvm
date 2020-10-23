package org.think.jvm.instructions.references;

import org.think.jvm.exceptions.VMException;
import org.think.jvm.instructions.Instruction;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.Thread;
import org.think.jvm.rtad.heap.ClassObject;

/*
*将栈顶的异常抛出
*@author lixiaobin
*/
public class ATHROW extends Instruction {

    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        ClassObject exObject = (ClassObject)visitor.getFrame().getStack().popRef();
        if(exObject == null ){
            throw new VMException("java.lang.NullPointException");
        }
        Thread thread = visitor.getFrame().getThread();
        if(findAndGoExceptionHandler(thread,exObject)){
            handleUncaughtException(thread,exObject);
        }
        log.debug(visitor.getFrame().getMethod().getName()+" execute");
    }

    public Boolean findAndGoExceptionHandler(Thread thread,ClassObject ex) {
        while (!thread.isStackEmpty()){
            Frame frame = thread.currentFrame();
            Integer pc = frame.getNextPC() - 1;
            Integer handlePc = frame.getMethod().findExceptionHandler(ex.getClazz(), pc);
            if (handlePc > 0) {
                OperandStack stack = frame.getStack();
                stack.clear();
                stack.pushRef(ex);
                frame.setNextPC(handlePc);
                return true;
            }
            thread.popFrame();
        }
        return false;
    }

    public void handleUncaughtException(Thread thread,Object ex){
        thread.stackClear();

        System.err.println();
    }
}
