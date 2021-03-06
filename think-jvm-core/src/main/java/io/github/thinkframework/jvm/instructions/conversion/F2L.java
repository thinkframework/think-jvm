package io.github.thinkframework.jvm.instructions.conversion;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶float型数值强制转换成long型数值并将结果压入栈顶
*@author lixiaobin
*/
public class F2L extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Long value = visitor.getFrame().getStack().popFloat().longValue();
        visitor.getFrame().getStack().pushLong(value);
    }
}
