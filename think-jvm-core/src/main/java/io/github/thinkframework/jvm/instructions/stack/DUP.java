package io.github.thinkframework.jvm.instructions.stack;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.Solt;

/*
*复制栈顶数值并将复制值压入栈顶
*@author lixiaobin
*/
public class DUP extends Instruction {

    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Solt slot = operandStack.popSolt();
        operandStack.pushSolt(slot);
        operandStack.pushSolt(slot);
    }
}
