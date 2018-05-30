package org.think.jvm.instructions.references;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.*;

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
