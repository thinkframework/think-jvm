package org.think.jvm.instructions.constants;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*将int型5推送至栈顶
*@author lixiaobin
*/
public class ICONST_5 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        visitor.getFrame().getStack().pushInt(5);
    }
}
