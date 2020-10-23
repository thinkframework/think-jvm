package org.think.jvm.instructions.references;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ClassRef;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ConstantPool;

/*
*创建一个引用型(如类,接口,数组)的数组,并将其引用值压入栈顶
*@author lixiaobin
*/
public class ANEWARRAY extends Index16Instruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
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
