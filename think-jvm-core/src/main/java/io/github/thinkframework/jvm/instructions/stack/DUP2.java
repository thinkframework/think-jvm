package io.github.thinkframework.jvm.instructions.stack;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.Solt;

/*
*复制栈顶一个(long或double类型的)或两个(其它)数值并将复制值压入栈顶
*@author lixiaobin
*/
public class DUP2 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Solt slot1 = operandStack.popSolt();
        Solt slot2 = operandStack.popSolt();
        operandStack.pushSolt(slot2);
        operandStack.pushSolt(slot1);
        operandStack.pushSolt(slot2);
        operandStack.pushSolt(slot1);
    }
}
