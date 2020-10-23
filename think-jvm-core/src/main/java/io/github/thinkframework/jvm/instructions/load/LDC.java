package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.exceptions.VMException;
import io.github.thinkframework.jvm.instructions.base.Index8Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.*;

/*
*将int,float或String型常量值从常量池中推送至栈顶
*@author lixiaobin
*/
public class LDC extends Index8Instruction {
    public void execute(Visitor visitor){
        super.execute(visitor);
        Method currentMethod = visitor.getFrame().getMethod();
        Clazz currentClazz = currentMethod.clazz;
        ConstantPool constantPool = currentClazz.getConstantPool();
        Constant constant = constantPool.getConstant(index);
        OperandStack operandStack = visitor.getFrame().getStack();
        switch (constant.getTag()){
            case Constant.CONSTANT_Integer:
                operandStack.pushInt(constant.getValue().intValue());
                break;
            case Constant.CONSTANT_Long:
                operandStack.pushLong(constant.getValue().longValue());
                break;
            case Constant.CONSTANT_Float:
                operandStack.pushFloat(constant.getValue().floatValue());
                break;
            case Constant.CONSTANT_Double:
                operandStack.pushDouble(constant.getValue().doubleValue());
                break;
            case Constant.CONSTANT_String:
                operandStack.pushRef(constant.getObject().toString());
                break;
            case Constant.CONSTANT_Class:
                ClassRef classRef = (ClassRef)constant;
                ClassObject classObject = classRef.resolvedClass().getClazzObject();
                operandStack.pushRef(classObject);
                break;
            default:
                throw new VMException("LDC");
        }
    }
}
