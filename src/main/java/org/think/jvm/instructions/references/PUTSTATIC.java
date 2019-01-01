package org.think.jvm.instructions.references;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.*;

/*
*为指定的类的静态域赋值
*@author lixiaobin
*/
public class PUTSTATIC extends Index16Instruction {
    public void execute(Visitor visitor){
        Method currentMethod = visitor.getFrame().getMethod();
        Clazz currentClazz = currentMethod.clazz;
        ConstantPool constantPool = currentClazz.getConstantPool();
        FieldRef fieldRef = (FieldRef)constantPool.getConstant(index);
        Field field = fieldRef.resolvedField();
        Clazz clazz = field.clazz;
        if(!clazz.getInitStared()){
            visitor.getFrame().revertNextPc();
            clazz.init(visitor.getFrame().getThread(),clazz);
            return;
        }
        super.execute(visitor);
        String descriptor = field.getDescriptor();
        Integer id = field.soltId;
        Solts staticVars = clazz.getStaticVars();
        OperandStack operandStack = visitor.getFrame().getStack();
        switch (descriptor.substring(0,1)){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                Integer integer = operandStack.popInt();
                staticVars.setInt(id,integer);
                break;
            case "J":
                Long aLong = operandStack.popLong();
                staticVars.setLong(id,aLong);
                break;
            case "F":
                Float aFloat = operandStack.popFloat();
                staticVars.setFloat(id,aFloat);
                break;
            case "D":
                Double aDouble = operandStack.popDouble();
                staticVars.setDouble(id,aDouble);
                break;
            case "L":
                staticVars.setRef(id,operandStack.popRef());
                break;
        }
    }

}
