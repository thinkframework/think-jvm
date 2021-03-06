package io.github.thinkframework.jvm.instructions.conversion;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶int型数值强制转换成float型数值并将结果压入栈顶
*@author lixiaobin
*/
public class I2F extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Float value = visitor.getFrame().getStack().popInt().floatValue();
        visitor.getFrame().getStack().pushFloat(value);
    }
}
