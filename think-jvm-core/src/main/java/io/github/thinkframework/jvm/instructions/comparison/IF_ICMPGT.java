package io.github.thinkframework.jvm.instructions.comparison;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.BranchInstruction;

/*
*比较栈顶两int型数值大小,当结果大于0时跳转
*@author lixiaobin
*/
public class IF_ICMPGT extends BranchInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer v2 = visitor.getFrame().getStack().popInt();
        Integer v1 = visitor.getFrame().getStack().popInt();
        if(v1 > v2){
            branch(visitor);
        }
    }
}
