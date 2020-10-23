package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶两float型数值相减并将结果压入栈顶
*@author lixiaobin
*/
public class FSUB extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Float v2 = visitor.getFrame().getStack().popFloat();
        Float v1 = visitor.getFrame().getStack().popFloat();
        Float result = v1 - v2;
        visitor.getFrame().getStack().pushFloat(result);
    }
}
