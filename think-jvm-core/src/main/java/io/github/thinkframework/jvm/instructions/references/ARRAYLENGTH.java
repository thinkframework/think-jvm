package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.ArrayObject;

/*
*获得数组的长度值并压入栈顶
*@author lixiaobin
*/
public class ARRAYLENGTH extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        int length = object.length();
        operandStack.pushRef(length);
    }

}
