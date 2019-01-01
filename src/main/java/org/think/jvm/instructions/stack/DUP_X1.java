package org.think.jvm.instructions.stack;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.Solt;

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
