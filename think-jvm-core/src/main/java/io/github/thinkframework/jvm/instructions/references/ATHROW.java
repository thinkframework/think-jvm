package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.exceptions.VMException;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.Frame;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.Thread;
import io.github.thinkframework.jvm.rtad.heap.ClassObject;

/*
*将栈顶的异常抛出
*@author lixiaobin
*/
public class ATHROW extends Instruction {

    public void execute(Visitor visitor){
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
