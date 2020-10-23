package org.think.jvm.instructions.conversion;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶int型数值强制转换成char型数值并将结果压入栈顶
*@author lixiaobin
*/
public class I2C extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Character value = (char)visitor.getFrame().getStack().popInt().intValue();
        visitor.getFrame().getStack().pushChar(value);
    }
}