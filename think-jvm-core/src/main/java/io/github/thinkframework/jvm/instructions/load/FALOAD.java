package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.ArrayObject;

/*
*将float型数组指定索引的值推送至栈顶
*@author lixiaobin
*/
public class FALOAD extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Integer value = operandStack.popInt();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        operandStack.pushFloat(object.getFloat(value));
    }
}
