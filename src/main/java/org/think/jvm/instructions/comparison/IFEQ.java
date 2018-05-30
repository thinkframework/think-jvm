package org.think.jvm.instructions.comparison;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.BranchInstruction;

/*
*当栈顶int型数值等于0时跳转
*@author lixiaobin
*/
public class IFEQ extends BranchInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getStack().popInt();
        if(value == 0){
            branch(visitor);
        }
    }
}

