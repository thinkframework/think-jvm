package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶int型数值取负并将结果压入栈顶
*@author lixiaobin
*/
public class INEG extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Integer value = visitor.getFrame().getStack().popInt();
        visitor.getFrame().getStack().pushInt(-value);
    }
}
