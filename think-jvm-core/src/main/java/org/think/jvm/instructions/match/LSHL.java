package org.think.jvm.instructions.match;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将long型数值左移位指定位数并将结果压入栈顶
*@author lixiaobin
*/
public class LSHL extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Long v2 = visitor.getFrame().getStack().popLong();
        Long v1 = visitor.getFrame().getStack().popLong();
        Long result = v1 + v2;
        visitor.getFrame().getStack().pushLong(result);
    }
}