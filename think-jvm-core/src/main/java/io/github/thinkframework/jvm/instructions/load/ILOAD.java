package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index8Instruction;

/*
*将指定的int型局部变量推送至栈顶
*@author lixiaobin
*/
public class ILOAD extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getLocalVars().getInt(index);
        visitor.getFrame().getStack().pushInt(value);
    }
}
