package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶long型数值存入第一个局部变量
*@author lixiaobin
*/
public class LSTORE_0 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Long value = visitor.getFrame().getStack().popLong();
        visitor.getFrame().getLocalVars().setLong(0,value);
    }
}
