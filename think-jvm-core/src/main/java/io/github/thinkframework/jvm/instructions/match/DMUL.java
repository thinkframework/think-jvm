package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶两double型数值相乘并将结果压入栈顶
*@author lixiaobin
*/
public class DMUL extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Double v2 = visitor.getFrame().getStack().popDouble();
        Double v1 = visitor.getFrame().getStack().popDouble();
        Double result = v1 * v2;
        visitor.getFrame().getStack().pushDouble(result);
    }
}
