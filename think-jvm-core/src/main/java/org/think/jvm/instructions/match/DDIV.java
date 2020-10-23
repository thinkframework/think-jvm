package org.think.jvm.instructions.match;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶两double型数值相除并将结果压入栈顶
*@author lixiaobin
*/
public class DDIV extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Double v2 = visitor.getFrame().getStack().popDouble();
        Double v1 = visitor.getFrame().getStack().popDouble();
        Double result = v1 / v2;
        visitor.getFrame().getStack().pushDouble(result);
    }
}
