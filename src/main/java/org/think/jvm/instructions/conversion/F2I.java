package org.think.jvm.instructions.conversion;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶float型数值强制转换成int型数值并将结果压入栈顶
*@author lixiaobin
*/
public class F2I extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getStack().popFloat().intValue();
        visitor.getFrame().getStack().pushInt(value);
    }
}