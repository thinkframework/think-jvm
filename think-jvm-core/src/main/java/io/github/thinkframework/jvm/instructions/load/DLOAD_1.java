package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将第二个double型局部变量推送至栈顶
*@author lixiaobin
*/
public class DLOAD_1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        Double value = visitor.getFrame().getLocalVars().getDouble(1);
        visitor.getFrame().getStack().pushDouble(value);
    }
}
