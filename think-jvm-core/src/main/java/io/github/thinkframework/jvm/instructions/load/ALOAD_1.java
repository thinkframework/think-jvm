package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

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
