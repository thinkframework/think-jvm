package org.think.jvm.instructions.conversion;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将栈顶double型数值强制转换成float型数值并将结果压入栈顶
*@author lixiaobin
*/
public class D2F extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Float value = visitor.getFrame().getStack().popDouble().floatValue();
        visitor.getFrame().getStack().pushFloat(value);
    }
}
