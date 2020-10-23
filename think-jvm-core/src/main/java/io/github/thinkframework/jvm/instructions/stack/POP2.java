package io.github.thinkframework.jvm.instructions.stack;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;

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
