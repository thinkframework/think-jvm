package io.github.thinkframework.jvm.instructions.comparison;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.BranchInstruction;

/*
*当栈顶int型数值不等于0时跳转
*@author lixiaobin
*/
public class IFNE extends BranchInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer value = visitor.getFrame().getStack().popInt();
        if(value != 0){
            branch(visitor);
        }
    }
}
