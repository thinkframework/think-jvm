package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

/*
*将第三个引用类型局部变量推送至栈顶
*@author lixiaobin
*/
public class ALOAD_2 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getLocalVars().getRef(2);
        visitor.getFrame().getStack().pushRef(object);
    }
}
