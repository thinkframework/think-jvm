package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index8Instruction;

/*
*将栈顶double型数值存入指定局部变量
*@author lixiaobin
*/
public class DSTORE extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Double value = visitor.getFrame().getStack().popDouble();
        visitor.getFrame().getLocalVars().setDouble(index,value);
    }
}
