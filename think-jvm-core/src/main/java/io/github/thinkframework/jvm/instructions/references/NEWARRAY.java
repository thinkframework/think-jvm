package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ClazzLoader;

/*
*创建一个指定原始类型(如int、float、char)的数组,并将其引用值压入栈顶
*@author lixiaobin
*/
public class NEWARRAY extends Instruction {
    public static final int AT_BOOLEAN = 4;
    public static final int AT_CHAR = 5;
    public static final int AT_FLOAT = 6;
    public static final int AT_DOUBLE = 7;
    public static final int AT_BYTE = 8;
    public static final int AT_SHORT = 9;
    public static final int AT_INT = 10;
    public static final int AT_LONG = 11;
    Integer atype;

    @Override
    public void accept(Visitor visitor){
        super.accept(visitor);
        atype = visitor.readUInt8();
    }


    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack =visitor.getFrame().getStack();
        int count = operandStack.popInt();
        Clazz clazz = getPrimitiveArrayClass(visitor);
        Object object = clazz.newArray(count);
        operandStack.pushRef(object);
    }

    public Clazz getPrimitiveArrayClass(Visitor visitor){
        ClazzLoader clazzLoader = visitor.getFrame().getMethod().getClazz().getClazzLoader();
        switch (atype){
            case AT_BOOLEAN:
                return clazzLoader.loadClass("[Z");
            case AT_CHAR:
                return clazzLoader.loadClass("[C");
            case AT_FLOAT:
                return clazzLoader.loadClass("[F");
            case AT_DOUBLE:
                return clazzLoader.loadClass("[D");
            case AT_BYTE:
                return clazzLoader.loadClass("[B");
            case AT_SHORT:
                return clazzLoader.loadClass("[S");
            case AT_INT:
                return clazzLoader.loadClass("[I");
            case AT_LONG:
                return clazzLoader.loadClass("[J");
            default:
                return null;
        }
    }
}
