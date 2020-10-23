package io.github.thinkframework.jvm.instructions.stack;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.Solt;

/*
*复制栈顶数值并将两个复制值压入栈顶
*@author lixiaobin
*/
public class DUP_X1 extends Instruction {

    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Solt slot1 = operandStack.popSolt();
        Solt slot2 = operandStack.popSolt();
        operandStack.pushSolt(slot1);
        operandStack.pushSolt(slot2);
        operandStack.pushSolt(slot1);
    }
}
