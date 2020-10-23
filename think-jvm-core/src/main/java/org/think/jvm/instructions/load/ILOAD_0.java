package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将第一个int型局部变量推送至栈顶
*@author lixiaobin
*/
public class ILOAD_0 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Integer value = visitor.getFrame().getLocalVars().getInt(0);
        visitor.getFrame().getStack().pushInt(value);
    }
}
