package org.think.jvm.instructions.stack;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.Visitor;
import org.think.jvm.rtad.OperandStack;

/*
*将栈顶数值弹出(数值不能是long或double类型的)
*@author lixiaobin
*/
public class POP extends Instruction {

    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        operandStack.popSolt();
    }
}
