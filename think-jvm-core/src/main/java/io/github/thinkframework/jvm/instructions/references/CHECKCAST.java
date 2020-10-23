package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.exceptions.VMException;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.*;

/*
*检验类型转换,检验未通过将抛出ClassCastException
*@author lixiaobin
*/
public class CHECKCAST extends Index16Instruction {
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        ClassObject ref= (ClassObject)operandStack.popRef();
        operandStack.pushRef(ref);
        if(ref == null){
            operandStack.pushInt(0);
        }

        Method currentMethod = visitor.getFrame().getMethod();
        Clazz currentClazz = currentMethod.clazz;
        ConstantPool constantPool = currentClazz.getConstantPool();
        ClassRef classRef = (ClassRef)constantPool.getConstant(index);
        Clazz clazz = classRef.resolvedClass();
        if(!ref.isInstanceOf(clazz)){
            throw new VMException("java.lang.ClassCastException");
        }
    }

}
