package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

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
