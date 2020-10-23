package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶float型数值存入第四个局部变量
*@author lixiaobin
*/
public class FSTORE_3 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Float value = visitor.getFrame().getStack().popFloat();
        visitor.getFrame().getLocalVars().setFloat(3,value);
    }
}
