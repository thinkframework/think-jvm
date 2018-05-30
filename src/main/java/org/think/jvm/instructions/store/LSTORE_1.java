package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶long型数值存入第二个局部变量
*@author lixiaobin
*/
public class LSTORE_1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Long value = visitor.getFrame().getStack().popLong();
        log.debug(value);
        visitor.getFrame().getLocalVars().setLong(1,value);
    }
}
