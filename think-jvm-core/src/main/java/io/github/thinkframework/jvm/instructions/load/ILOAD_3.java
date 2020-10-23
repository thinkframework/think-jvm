package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

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
