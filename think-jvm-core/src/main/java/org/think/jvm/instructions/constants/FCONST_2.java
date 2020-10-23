package org.think.jvm.instructions.constants;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将float型2推送至栈顶
*@author lixiaobin
*/
public class FCONST_2 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        visitor.getFrame().getStack().pushFloat(2f);
    }
}
