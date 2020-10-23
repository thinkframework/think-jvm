package org.think.jvm.instructions.extended;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ArrayObject;
import org.think.jvm.rtad.heap.ClassRef;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ConstantPool;

/*
*创建指定类型和指定维度的多维数组(执行该指令时,操作栈中必须包含各维度的长度值),并将其引用值压入栈顶
*@author lixiaobin
*/
public class MULTIANEWARRAY extends Instruction {
    Integer index;
    Integer dimensions;
    public void accept(org.think.jvm.Visitor visitor){
        super.accept(visitor);
        index = visitor.readUInt16();
        dimensions = visitor.readUInt8();
    }
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        ConstantPool constantPool = visitor.getFrame().getMethod().getClazz().getConstantPool();
        ClassRef classRef = (ClassRef)constantPool.getConstant(index);
        Clazz clazz = classRef.resolvedClass();
        OperandStack operandStack = visitor.getFrame().getStack();
        Integer[] counts = popAndCheckcounts(operandStack,dimensions);
        Object object = newMultiDimensionalArray(counts,clazz);
        operandStack.pushRef(object);
    }

    public Integer[] popAndCheckcounts(OperandStack operandStack,Integer dimensions){
        Integer[] counts = new Integer[dimensions];
        for(int i = dimensions-1;i>=0;i--){
            counts[i] = operandStack.popInt();
        }
        return counts;
    }

    public Object newMultiDimensionalArray(Integer[] counts,Clazz clazz){
        int count = counts[0];
        ArrayObject object = clazz.newArray(count);
        Object[] objects = object.getObjects();
//        for(int i=0;i<objects.length;i++){
//            objects[i] = newMultiDimensionalArray()
//        }
        return  object;
    }
}
