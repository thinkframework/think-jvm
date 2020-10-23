package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

/*
*将栈顶引用型数值存入第三个局部变量
*@author lixiaobin
*/
public class ASTORE_2 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getStack().popRef();
        visitor.getFrame().getLocalVars().setRef(2,object);
    }
}
