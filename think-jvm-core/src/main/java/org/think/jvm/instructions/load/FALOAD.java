package org.think.jvm.instructions.load;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ArrayObject;

/*
*将float型数组指定索引的值推送至栈顶
*@author lixiaobin
*/
public class FALOAD extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Integer value = operandStack.popInt();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        operandStack.pushFloat(object.getFloat(value));
    }
}
