package org.think.jvm.instructions.references;

import org.think.jvm.Visitor;
import org.think.jvm.exceptions.VMException;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.*;
import org.think.jvm.rtad.heap.ClassObject;
/*
*为指定的类的实例域赋值
*@author lixiaobin
*/
public class PUTFIELD extends Index16Instruction {
    public void execute(Visitor visitor){
        super.execute(visitor);
        Method currentMethod = visitor.getFrame().getMethod();
        Clazz currentClazz = currentMethod.clazz;
        ConstantPool constantPool = currentClazz.getConstantPool();
        FieldRef fieldRef = (FieldRef)constantPool.getConstant(index);
        Field field = fieldRef.resolvedField();
//        org.think.jvm.rtad.heap.Class clazz = field.clazz;

        String descriptor = field.getDescriptor();
        Integer id = field.soltId;
//        Solts staticVars = clazz.staticVars;
        OperandStack operandStack = visitor.getFrame().getStack();
        ClassObject value;
        switch (descriptor.substring(0,1)){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                Integer integer = operandStack.popInt();
                value= (ClassObject) operandStack.popRef();
                if(value == null){
                    throw new VMException("java.lang.NullPointException");
                }
                value.getFields().setInt(id,integer);
                break;
            case "J":
                Long aLong = operandStack.popLong();
                value= (ClassObject) operandStack.popRef();
                if(value == null){
                    throw new VMException("java.lang.NullPointException");
                }
                value.getFields().setLong(id,aLong);
                break;
            case "F":
                Float aFloat = operandStack.popFloat();
                value= (ClassObject) operandStack.popRef();
                if(value == null){
                    throw new VMException("java.lang.NullPointException");
                }
                value.getFields().setFloat(id,aFloat);
                break;
            case "D":
                Double aDouble = operandStack.popDouble();
                value= (ClassObject) operandStack.popRef();
                if(value == null){
                    throw new VMException("java.lang.NullPointException");
                }
                value.getFields().setDouble(id,aDouble);
                break;
            case "L":
                ClassObject classObject = (ClassObject)operandStack.popRef();
                value= (ClassObject)operandStack.popRef();
                if(value == null){
                    throw new VMException("java.lang.NullPointException");
                }
                value.getFields().setRef(id,classObject);
                break;
        }
    }
}
