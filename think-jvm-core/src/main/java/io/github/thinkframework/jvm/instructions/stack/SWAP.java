package io.github.thinkframework.jvm.instructions.stack;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.Solt;

/*
*将栈最顶端的两个数值互换(数值不能是long或double类型的)
*@author lixiaobin
*/
public class SWAP extends Instruction {

    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Solt slot1 = operandStack.popSolt();
        Solt slot2 = operandStack.popSolt();
        operandStack.pushSolt(slot1);
        operandStack.pushSolt(slot2);
    }
}
