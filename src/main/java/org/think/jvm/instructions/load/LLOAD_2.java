package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将第三个long型局部变量推送至栈顶
*@author lixiaobin
*/
public class LLOAD_2 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        Long value = visitor.getFrame().getLocalVars().getLong(0);
        log.debug(value);
        visitor.getFrame().getStack().pushLong(value);
    }
}
