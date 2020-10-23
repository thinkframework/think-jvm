package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶long型数值取负并将结果压入栈顶
*@author lixiaobin
*/
public class LNEG extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Long value = visitor.getFrame().getStack().popLong();
        visitor.getFrame().getStack().pushLong(-value);
    }
}
