package org.think.jvm.instructions.references;

import org.think.jvm.Visitor;
import org.think.jvm.exceptions.VMException;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.heap.*;

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
