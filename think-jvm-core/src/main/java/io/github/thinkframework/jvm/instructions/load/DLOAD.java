package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index8Instruction;

/*
*将指定的double型局部变量推送至栈顶
*@author lixiaobin
*/
public class DLOAD extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Double value = visitor.getFrame().getLocalVars().getDouble(index);
        visitor.getFrame().getStack().pushDouble(value);
    }
}
