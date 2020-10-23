package io.github.thinkframework.jvm.instructions.comparison;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.BranchInstruction;

/*
*比较栈顶两引用型数值,当结果不相等时跳转
*@author lixiaobin
*/
public class IF_ACMPNE extends BranchInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer v2 = visitor.getFrame().getStack().popInt();
        Integer v1 = visitor.getFrame().getStack().popInt();
        if(v1 != v2){
            branch(visitor);
        }
    }
}
