package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.ArrayObject;

/*
*将栈顶float型数值存入指定数组的指定索引位置
*@author lixiaobin
*/
public class FASTORE extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        Float value = operandStack.popFloat();
        Integer index = operandStack.popInt();
        ArrayObject object = (ArrayObject)operandStack.popRef();
        object.setFloat(index,value);
    }
}
