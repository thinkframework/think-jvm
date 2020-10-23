package io.github.thinkframework.jvm.instructions.conversion;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶double型数值强制转换成int型数值并将结果压入栈顶
*@author lixiaobin
*/
public class D2I extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getStack().popDouble().intValue();
        visitor.getFrame().getStack().pushInt(value);
    }
}
