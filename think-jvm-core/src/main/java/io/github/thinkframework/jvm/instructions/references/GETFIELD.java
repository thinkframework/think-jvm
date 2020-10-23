package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.*;

/*
*获取指定类的实例域,并将其值压入栈顶
*@author lixiaobin
*/
public class GETFIELD extends Index16Instruction {
    public void execute(Visitor visitor){
        super.execute(visitor);
        Method currentMethod = visitor.getFrame().getMethod();
        Clazz currentClazz = currentMethod.clazz;
        ConstantPool constantPool = currentClazz.getConstantPool();
        FieldRef fieldRef = (FieldRef)constantPool.getConstant(index);
        Field field = fieldRef.resolvedField();

        String descriptor = field.getDescriptor();
        Integer id = field.soltId;
        OperandStack operandStack = visitor.getFrame().getStack();
        ClassObject ref= (ClassObject) operandStack.popRef();
        Solts fields = ref.getFields();
        switch (descriptor.substring(0,1)){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                operandStack.pushInt(fields.getInt(id));
                break;
            case "J":
                operandStack.pushLong(fields.getLong(id));
                break;
            case "F":
                operandStack.pushFloat(fields.getFloat(id));
                break;
            case "D":
                operandStack.pushDouble(fields.getDouble(id));
                break;
            case "L":
            case "[":
                operandStack.pushRef(fields.getRef(id));
                break;
        }
    }
}
