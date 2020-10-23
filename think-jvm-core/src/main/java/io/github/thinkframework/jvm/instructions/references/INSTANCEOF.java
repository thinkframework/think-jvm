package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.*;

/*
*检验对象是否是指定的类的实例,如果是将1压入栈顶,否则将0压入栈顶
*@author lixiaobin
*/
public class INSTANCEOF extends Index16Instruction {
    public void execute(Visitor visitor){
        super.execute(visitor);
        OperandStack operandStack = visitor.getFrame().getStack();
        ClassObject ref= (ClassObject)operandStack.popRef();
        if(ref == null){
            operandStack.pushInt(0);
        }

        Method currentMethod = visitor.getFrame().getMethod();
        Clazz currentClazz = currentMethod.clazz;
        ConstantPool constantPool = currentClazz.getConstantPool();
        ClassRef classRef = (ClassRef)constantPool.getConstant(index);
        Clazz clazz = classRef.resolvedClass();
        if(ref.isInstanceOf(clazz)){
            operandStack.pushInt(1);
        }else{
            operandStack.pushInt(0);
        }
    }
}
