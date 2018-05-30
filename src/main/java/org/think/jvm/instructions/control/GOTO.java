package org.think.jvm.instructions.control;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.BranchInstruction;
import org.think.jvm.rtad.Frame;

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