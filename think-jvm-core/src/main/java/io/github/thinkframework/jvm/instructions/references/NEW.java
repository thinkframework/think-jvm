package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.exceptions.VMException;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.heap.ClassObject;
import io.github.thinkframework.jvm.rtad.heap.ClassRef;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ConstantPool;

/*
*创建一个对象,并将其引用值压入栈顶
*@author lixiaobin
*/
public class NEW extends Index16Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        ConstantPool constantPool = visitor.getFrame().getMethod().getClazz().getConstantPool();
        ClassRef classRef = (ClassRef)constantPool.getConstant(index);
        Clazz clazz = classRef.resolvedClass();
        if(!clazz.getInitStared()){
            visitor.getFrame().revertNextPc();
            clazz.init(visitor.getFrame().getThread(),clazz);
            return;
        }
        super.execute(visitor);
        if(clazz.getAccessFlags().isInterface() || clazz.getAccessFlags().isAbstract()){
            throw new VMException("java.lang.InstantiationError");
        }
        ClassObject object = clazz.newObject();
        visitor.getFrame().getStack().pushRef(object);
    }

}
