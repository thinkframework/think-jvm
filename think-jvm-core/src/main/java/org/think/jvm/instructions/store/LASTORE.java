package org.think.jvm.instructions.store;

import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ArrayObject;

/*
*将栈顶long型数值存入指定数组的指定索引位置
*@author lixiaobin
*/
public class LASTORE extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Long value = operandStack.popLong();
        Integer index = operandStack.popInt();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        object.setLong(index,value);
    }
}
