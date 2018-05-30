package org.think.jvm.instructions.match;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶float型数值取负并将结果压入栈顶
*@author lixiaobin
*/
public class FNEG extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Float value = visitor.getFrame().getStack().popFloat();
        visitor.getFrame().getStack().pushFloat(-value);
    }
}