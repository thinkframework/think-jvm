package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将第一个long型局部变量推送至栈顶
*@author lixiaobin
*/
public class LLOAD_0 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        Long value = visitor.getFrame().getLocalVars().getLong(0);
        visitor.getFrame().getStack().pushLong(value);
    }
}
