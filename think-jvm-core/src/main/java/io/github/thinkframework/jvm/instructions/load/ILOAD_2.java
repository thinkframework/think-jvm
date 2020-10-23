package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

/*
*将第三个int型局部变量推送至栈顶
*@author lixiaobin
*/
public class ILOAD_2 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        Integer value = visitor.getFrame().getLocalVars().getInt(2);
        visitor.getFrame().getStack().pushInt(value);
    }
}
