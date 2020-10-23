package org.think.jvm.instructions.comparison;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.BranchInstruction;

/*
*比较栈顶两int型数值大小,当结果等于0时跳转
*@author lixiaobin
*/
public class IF_ICMPEQ extends BranchInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer v2 = visitor.getFrame().getStack().popInt();
        Integer v1 = visitor.getFrame().getStack().popInt();
        if(v1 == v2){
            branch(visitor);
        }
    }
}