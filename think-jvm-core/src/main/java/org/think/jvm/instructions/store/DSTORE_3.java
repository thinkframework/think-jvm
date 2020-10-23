package org.think.jvm.instructions.store;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶double型数值存入第四个局部变量
*@author lixiaobin
*/
public class DSTORE_3 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        Double value = visitor.getFrame().getStack().popDouble();
        visitor.getFrame().getLocalVars().setDouble(0,value);
    }
}
