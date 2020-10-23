package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index8Instruction;

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
