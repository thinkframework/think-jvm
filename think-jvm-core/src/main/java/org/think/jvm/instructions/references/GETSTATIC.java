package org.think.jvm.instructions.references;

import org.think.jvm.Visitor;
import org.think.jvm.exceptions.VMException;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.*;

/*
*获取指定类的静态域,并将其值压入栈顶
*@author lixiaobin
*/
public class GETSTATIC extends Index16Instruction {
    public void execute(Visitor visitor){
        super.execute(visitor);
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
        String descriptor = field.getDescriptor();
        Integer id = field.soltId;
        Solts staticVars = clazz.getStaticVars();
        OperandStack operandStack = visitor.getFrame().getStack();
        switch (descriptor){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                operandStack.pushInt(staticVars.getInt(id));
                break;
            case "J":
                operandStack.pushLong(staticVars.getLong(id));
                break;
            case "F":
                operandStack.pushFloat(staticVars.getFloat(id));
                break;
            case "D":
                operandStack.pushDouble(staticVars.getDouble(id));
                break;
            case "Ljava/lang/String":
                operandStack.pushRef(staticVars.getRef(id));
                break;
            default:
                operandStack.pushRef(staticVars.getRef(id));
                break;
//                throw new VMException(descriptor);
        }
    }
}
