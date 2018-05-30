package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.heap.*;

/*
*将int,float或String型常量值从常量池中推送至栈顶(宽索引)
*@author lixiaobin
*/
public class LDC_W extends Index16Instruction {
    public void execute(Visitor visitor){
        super.execute(visitor);
        Method currentMethod = visitor.getFrame().getMethod();
        Clazz currentClazz = currentMethod.clazz;
        ConstantPool constantPool = currentClazz.getConstantPool();
        Constant constant = constantPool.getConstant(index);
//        Field field = fieldRef.resolvedField();
//        org.think.jvm.rtad.heap.Class clazz = field.clazz;

//        String descriptor = field.getType();
//        Integer id = field.soltId;
//        OperandStack operandStack = visitor.getFrame().getStack();
//        switch (descriptor){
//            case "Z":
//            case "B":
//            case "C":
//            case "S":
//            case "I":
//                operandStack.pushInt();
//                break;
//            case "J":
//                operandStack.pushInt();
//                break;
//            case "F":
//                operandStack.pushInt();
//                break;
//            case "D":
//                operandStack.pushInt();
//                break;
//            case "Ljava.lang.String":
////                Double aDouble = operandStack.popRef();
////                value= operandStack.popRef();
////                value.fields.setDouble(id,aDouble);
//                break;
//        }
    }
}
