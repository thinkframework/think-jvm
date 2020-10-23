package org.think.jvm.instructions.references;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ArrayObject;

/*
*获得数组的长度值并压入栈顶
*@author lixiaobin
*/
public class ARRAYLENGTH extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        int length = object.length();
        operandStack.pushRef(length);
    }

}
