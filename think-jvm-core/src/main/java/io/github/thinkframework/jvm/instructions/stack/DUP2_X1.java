package io.github.thinkframework.jvm.instructions.stack;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.Solt;

/*
*dup_x1指令的双倍版本
*@author lixiaobin
*/
public class DUP2_X1 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Solt slot1 = operandStack.popSolt();
        Solt slot2 = operandStack.popSolt();
        Solt slot3 = operandStack.popSolt();
        operandStack.pushSolt(slot2);
        operandStack.pushSolt(slot1);
        operandStack.pushSolt(slot3);
        operandStack.pushSolt(slot2);
        operandStack.pushSolt(slot1);
    }
}
