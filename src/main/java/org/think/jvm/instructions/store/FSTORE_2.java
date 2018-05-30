package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶float型数值存入第三个局部变量
*@author lixiaobin
*/
public class FSTORE_2 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Float value = visitor.getFrame().getStack().popFloat();
        log.debug(value);
        visitor.getFrame().getLocalVars().setFloat(2,value);
    }
}
