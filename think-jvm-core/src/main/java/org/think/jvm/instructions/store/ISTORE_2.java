package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶int型数值存入第三个局部变量
*@author lixiaobin
*/
public class ISTORE_2 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Integer value = visitor.getFrame().getStack().popInt();
        log.debug(value);
        visitor.getFrame().getLocalVars().setInt(2,value);
    }
}
