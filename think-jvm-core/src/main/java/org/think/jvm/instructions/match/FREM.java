package org.think.jvm.instructions.match;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶两float型数值作取模运算并将结果压入栈顶
*@author lixiaobin
*/
public class FREM extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Float v2 = visitor.getFrame().getStack().popFloat();
        Float v1 = visitor.getFrame().getStack().popFloat();
        Float result = v1 % v2;
        visitor.getFrame().getStack().pushFloat(result);
    }
}
