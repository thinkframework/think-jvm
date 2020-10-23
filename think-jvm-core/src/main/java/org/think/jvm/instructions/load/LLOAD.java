package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

/*
*将指定的long型局部变量推送至栈顶
*@author lixiaobin
*/
public class LLOAD extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Long value = visitor.getFrame().getStack().popLong();
        visitor.getFrame().getLocalVars().setLong(index,value);
    }
}
