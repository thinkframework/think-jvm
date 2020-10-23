package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

/*
*将栈顶int型数值存入指定局部变量
*@author lixiaobin
*/
public class ISTORE extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getStack().popInt();
        visitor.getFrame().getLocalVars().setInt(index,value);
    }
}
