package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将第一个int型局部变量推送至栈顶
*@author lixiaobin
*/
public class ILOAD_0 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Integer value = visitor.getFrame().getLocalVars().getInt(0);
        visitor.getFrame().getStack().pushInt(value);
    }
}
