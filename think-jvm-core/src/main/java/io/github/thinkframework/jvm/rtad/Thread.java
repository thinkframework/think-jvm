package io.github.thinkframework.jvm.rtad;

import io.github.thinkframework.jvm.rtad.heap.Method;

import java.util.Stack;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Thread {
    private int pc;
    Stack<Frame> stack;
    public Thread(){
        stack = new Stack<Frame>();
    }


    public void pushFrame(Frame frame){
        stack.push(frame);
    }


    public Frame popFrame(){
        return stack.pop();
    }

    public Frame currentFrame(){
        return stack.peek();
    }

    public Frame topFrame(){
        return stack.peek();
    }

    public Frame newFrame(Method method){
        return new Frame(this,method);
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public Stack<Frame> getStack() {
        return stack;
    }

    public void setStack(Stack<Frame> stack) {
        this.stack = stack;
    }

    public Boolean isStackEmpty(){
        return stack.empty();
    }


    public void stackClear(){
        stack.clear();
    }
}
