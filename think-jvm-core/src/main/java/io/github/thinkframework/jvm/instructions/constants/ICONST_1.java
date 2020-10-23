package io.github.thinkframework.jvm.instructions.constants;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将int型1推送至栈顶
*@author lixiaobin
*/
public class ICONST_1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        visitor.getFrame().getStack().pushInt(1);
    }
}
