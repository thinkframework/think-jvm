package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶double型数值存入第四个局部变量
*@author lixiaobin
*/
public class DSTORE_3 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Double value = visitor.getFrame().getStack().popDouble();
        visitor.getFrame().getLocalVars().setDouble(0,value);
    }
}
