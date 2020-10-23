package org.think.jvm.instructions.control;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;

/*
*从当前方法返回void
*@author lixiaobin
*/
public class RETURN extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        visitor.getFrame().getThread().popFrame();
    }
}