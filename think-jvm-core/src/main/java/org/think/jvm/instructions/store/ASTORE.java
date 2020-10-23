package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

/*
*将栈顶引用型数值存入指定局部变量
*@author lixiaobin
*/
public class ASTORE extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getStack().popRef();
        visitor.getFrame().getLocalVars().setRef(index,object);
    }
}
