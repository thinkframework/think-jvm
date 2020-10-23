package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;

/*
*将栈顶引用型数值存入第二个局部变量
*@author lixiaobin
*/
public class ASTORE_1 extends Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getStack().popRef();
        visitor.getFrame().getLocalVars().setRef(1,object);
    }
}
