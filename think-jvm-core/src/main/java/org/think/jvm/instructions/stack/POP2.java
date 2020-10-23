package org.think.jvm.instructions.stack;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;
import org.think.jvm.rtad.OperandStack;

/*
*将栈顶的一个(long或double类型的)或两个数值弹出(其它)
*@author lixiaobin
*/
public class POP2 extends Instruction {

    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        operandStack.popSolt();
        operandStack.popSolt();
    }
}
