package org.think.jvm.instructions.store;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.Visitor;

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
