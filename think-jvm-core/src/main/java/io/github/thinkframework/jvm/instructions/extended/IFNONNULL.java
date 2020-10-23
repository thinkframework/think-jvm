package io.github.thinkframework.jvm.instructions.extended;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.BranchInstruction;

/*
*不为null时跳转
*@author lixiaobin
*/
public class IFNONNULL extends BranchInstruction {

    public void execute(Visitor visitor){
        super.execute(visitor);
        Object object = visitor.getFrame().getStack().popRef();
        if(object != null){
            branch(visitor);
        }
    }
}
