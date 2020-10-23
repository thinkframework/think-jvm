package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index8Instruction;

/*
*将栈顶float型数值存入指定局部变量
*@author lixiaobin
*/
public class FSTORE extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Float value = visitor.getFrame().getStack().popFloat();
        visitor.getFrame().getLocalVars().setFloat(index,value);
    }
}
