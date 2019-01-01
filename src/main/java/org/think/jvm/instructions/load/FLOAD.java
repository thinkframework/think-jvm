package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

/*
*将指定的float型局部变量推送至栈顶
*@author lixiaobin
*/
public class FLOAD extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Float value = visitor.getFrame().getLocalVars().getFloat(index);
        visitor.getFrame().getStack().pushFloat(value);
    }
}
