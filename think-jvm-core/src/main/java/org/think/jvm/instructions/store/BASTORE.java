package org.think.jvm.instructions.store;

import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ArrayObject;

/*
*将栈顶boolean或byte型数值存入指定数组的指定索引位置
*@author lixiaobin
*/
public class BASTORE extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Byte value = operandStack.popByte();
        Integer index = operandStack.popInt();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        object.setByte(index,value);
    }
}
