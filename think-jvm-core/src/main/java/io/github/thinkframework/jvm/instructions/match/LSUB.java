package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶两long型数值相减并将结果压入栈顶
*@author lixiaobin
*/
public class LSUB extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Long v2 = visitor.getFrame().getStack().popLong();
        Long v1 = visitor.getFrame().getStack().popLong();
        Long result = v1 - v2;
        visitor.getFrame().getStack().pushLong(result);
    }
}
