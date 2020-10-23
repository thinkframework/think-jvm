package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将第四个double型局部变量推送至栈顶
*@author lixiaobin
*/
public class DLOAD_3 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        Double value = visitor.getFrame().getLocalVars().getDouble(3);
        visitor.getFrame().getStack().pushDouble(value);
    }
}
