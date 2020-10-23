package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

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
