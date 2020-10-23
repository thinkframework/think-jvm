package io.github.thinkframework.jvm.instructions.conversion;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶int型数值强制转换成short型数值并将结果压入栈顶
*@author lixiaobin
*/
public class I2S extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Short value = visitor.getFrame().getStack().popDouble().shortValue();
        visitor.getFrame().getStack().pushShort(value);
    }
}
