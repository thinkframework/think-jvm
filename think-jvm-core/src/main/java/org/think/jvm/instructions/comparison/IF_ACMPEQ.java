package org.think.jvm.instructions.comparison;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.BranchInstruction;

/*
*比较栈顶两引用型数值,当结果相等时跳转
*@author lixiaobin
*/
public class IF_ACMPEQ extends BranchInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Object v2 = visitor.getFrame().getStack().popRef();
        Object v1 = visitor.getFrame().getStack().popRef();
        if(v1 == v2){
            branch(visitor);
        }
    }
}
