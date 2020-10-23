package org.think.jvm.instructions.constants;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将long型1推送至栈顶
*@author lixiaobin
*/
public class LCONST_1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        visitor.getFrame().getStack().pushLong(1l);
    }
}
