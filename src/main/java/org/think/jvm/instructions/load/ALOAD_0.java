package org.think.jvm.instructions.load;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.Visitor;

/*
*将第一个引用类型局部变量推送至栈顶
*@author lixiaobin
*/
public class ALOAD_0 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getLocalVars().getRef(0);
        visitor.getFrame().getStack().pushRef(object);
    }
}
