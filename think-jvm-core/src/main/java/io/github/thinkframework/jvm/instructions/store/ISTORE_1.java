package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶int型数值存入第二个局部变量
*@author lixiaobin
*/
public class ISTORE_1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Integer value = visitor.getFrame().getStack().popInt();
        visitor.getFrame().getLocalVars().setInt(1,value);
    }
}
