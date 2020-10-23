package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将第四个float型局部变量推送至栈顶
*@author lixiaobin
*/
public class FLOAD_3 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        Float value = visitor.getFrame().getLocalVars().getFloat(3);
        visitor.getFrame().getStack().pushFloat(value);
    }
}
