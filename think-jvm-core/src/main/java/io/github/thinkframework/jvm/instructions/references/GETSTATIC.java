package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.*;

/*
*获取指定类的静态域,并将其值压入栈顶
*@author lixiaobin
*/
public class GETSTATIC extends Index16Instruction {
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
            case "L":
                operandStack.pushRef(staticVars.getRef(id));
                break;
            default:
//                operandStack.pushRef(staticVars.getRef(id));
//                break;
//                throw new VMException(descriptor);
        }
    }
}
