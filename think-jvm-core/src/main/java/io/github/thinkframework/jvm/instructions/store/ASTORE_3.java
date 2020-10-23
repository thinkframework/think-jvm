package io.github.thinkframework.jvm.instructions.store;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

/*
*将栈顶引用型数值存入第四个局部变量
*@author lixiaobin
*/
public class ASTORE_3 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getStack().popRef();
        visitor.getFrame().getLocalVars().setRef(3,object);
    }
}
