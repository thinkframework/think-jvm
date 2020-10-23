package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

/*
*将指定的引用类型局部变量推送至栈顶
*@author lixiaobin
*/
public class ALOAD extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getLocalVars().getRef(index);
        visitor.getFrame().getStack().pushRef(object);
    }
}
