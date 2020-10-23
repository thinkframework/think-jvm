package org.think.jvm.instructions.load;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index8Instruction;

/*
*将指定的double型局部变量推送至栈顶
*@author lixiaobin
*/
public class DLOAD extends Index8Instruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Double value = visitor.getFrame().getStack().popDouble();
        visitor.getFrame().getLocalVars().setDouble(index,value);
    }
}
