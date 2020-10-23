package org.think.jvm.instructions.store;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ArrayObject;

/*
*将栈顶float型数值存入指定数组的指定索引位置
*@author lixiaobin
*/
public class FASTORE extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Float value = operandStack.popFloat();
        Integer index = operandStack.popInt();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        object.setFloat(index,value);
    }
}