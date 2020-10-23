package org.think.jvm.instructions.extended;

import org.think.jvm.instructions.base.BranchInstruction;

/*
*为null时跳转
*@author lixiaobin
*/
public class IFNULL extends BranchInstruction {

    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getStack().popRef();
        if(object == null){
            branch(visitor);
        }
    }
}
