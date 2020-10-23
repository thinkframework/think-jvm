package org.think.jvm.instructions.conversion;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶long型数值强制转换成int型数值并将结果压入栈顶
*@author lixiaobin
*/
public class L2I extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getStack().popLong().intValue();
        visitor.getFrame().getStack().pushInt(value);
    }
}
