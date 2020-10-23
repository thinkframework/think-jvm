package io.github.thinkframework.jvm.instructions.conversion;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

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
