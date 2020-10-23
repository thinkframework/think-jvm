package io.github.thinkframework.jvm.rtad;

import io.github.thinkframework.jvm.rtad.heap.Method;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Frame {
    private Frame lower;
    private LocalVars localVars;
    private OperandStack operandStack;
    private Thread thread;
    private int nextPC;
    private Method method;
    private Frame(){

    }

    public Frame(Thread thread,Method method){
        this.thread = thread;
        this.method = method;
        localVars = new LocalVars(method.maxLocals);
        operandStack = new OperandStack(method.maxStack);
    }

    public Frame getLower() {
        return lower;
    }

    public void setLower(Frame lower) {
        this.lower = lower;
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public void setLocalVars(LocalVars localVars) {
        this.localVars = localVars;
    }

    public OperandStack getStack() {
        return operandStack;
    }

    public void setStack(OperandStack operandStack) {
        this.operandStack = operandStack;
    }

    public int getNextPC() {
        return nextPC;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void revertNextPc(){
        nextPC = thread.getPC();
    }
}
