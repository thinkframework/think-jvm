package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

/*
*将指定的int型局部变量推送至栈顶
*@author lixiaobin
*/
public class ILOAD extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getLocalVars().getInt(index);
        visitor.getFrame().getStack().pushInt(value);
    }
}