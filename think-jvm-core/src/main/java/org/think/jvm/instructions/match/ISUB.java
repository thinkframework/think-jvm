package org.think.jvm.instructions.match;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶两int型数值相减并将结果压入栈顶
*@author lixiaobin
*/
public class ISUB extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Integer v2 = visitor.getFrame().getStack().popInt();
        Integer v1 = visitor.getFrame().getStack().popInt();
        Integer result = v1 - v2;
        visitor.getFrame().getStack().pushInt(result);
    }
}