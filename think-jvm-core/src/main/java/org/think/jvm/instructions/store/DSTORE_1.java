package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶double型数值存入第二个局部变量
*@author lixiaobin
*/
public class DSTORE_1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Double value = visitor.getFrame().getStack().popDouble();
        log.debug(value);
        visitor.getFrame().getLocalVars().setDouble(0,value);
    }
}
