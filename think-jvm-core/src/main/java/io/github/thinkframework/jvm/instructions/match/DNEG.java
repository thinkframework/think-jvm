package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶double型数值取负并将结果压入栈顶
*@author lixiaobin
*/
public class DNEG extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Double value = visitor.getFrame().getStack().popDouble();
        visitor.getFrame().getStack().pushDouble(-value);
    }
}

