package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

/*
*将第四个引用类型局部变量推送至栈顶
*@author lixiaobin
*/
public class ALOAD_3 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getLocalVars().getRef(3);
        visitor.getFrame().getStack().pushRef(object);
    }
}
