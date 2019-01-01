package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将第二个long型局部变量推送至栈顶
*@author lixiaobin
*/
public class LLOAD_1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        Long value = visitor.getFrame().getLocalVars().getLong(1);
        visitor.getFrame().getStack().pushLong(value);
    }
}
