package org.think.jvm.instructions.conversion;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶int型数值强制转换成byte型数值并将结果压入栈顶
*@author lixiaobin
*/
public class I2B extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Byte value = visitor.getFrame().getStack().popInt().byteValue();
        visitor.getFrame().getStack().pushByte(value);
    }
}