package io.github.thinkframework.jvm.instructions.control;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.BranchInstruction;

/*
*无条件跳转
*@author lixiaobin
*/
public class GOTO extends BranchInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        branch(visitor);
    }
}
