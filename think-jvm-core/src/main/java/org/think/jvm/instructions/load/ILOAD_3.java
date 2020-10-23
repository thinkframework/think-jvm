package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;

/*
*将第四个int型局部变量推送至栈顶
*@author lixiaobin
*/
public class ILOAD_3 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        Integer value = visitor.getFrame().getLocalVars().getInt(3);
        visitor.getFrame().getStack().pushInt(value);
    }
}
