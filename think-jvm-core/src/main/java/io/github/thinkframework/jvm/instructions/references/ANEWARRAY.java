package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.ClassRef;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ConstantPool;

/*
*创建一个引用型(如类,接口,数组)的数组,并将其引用值压入栈顶
*@author lixiaobin
*/
public class ANEWARRAY extends Index16Instruction {
    @Override
    public void execute(Visitor visitor){
        ConstantPool constantPool = visitor.getFrame().getMethod().getClazz().getConstantPool();
        ClassRef classRef = (ClassRef)constantPool.getConstant(index);
        Clazz clazz = classRef.resolvedClass();
        OperandStack operandStack = visitor.getFrame().getStack();
        int count = operandStack.popInt();
        Clazz arrayClass = clazz.ArrayClass();
        Object object = arrayClass.newArray(count);
        operandStack.pushRef(object);
    }

}
