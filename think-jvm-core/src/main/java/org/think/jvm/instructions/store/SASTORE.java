package org.think.jvm.instructions.store;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ArrayObject;

/*
*将栈顶short型数值存入指定数组的指定索引位置
*@author lixiaobin
*/
public class SASTORE extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Short value = operandStack.popShort();
        Integer index = operandStack.popInt();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        object.setShort(index,value);
    }
}
