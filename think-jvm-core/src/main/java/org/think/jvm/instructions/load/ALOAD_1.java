package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;

/*
*将第二个引用类型局部变量推送至栈顶
*@author lixiaobin
*/
public class ALOAD_1 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getLocalVars().getRef(1);
        visitor.getFrame().getStack().pushRef(object);
    }
}
