package io.github.thinkframework.jvm.instructions.comparison;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*比较栈顶两long型数值大小,并将结果(1,0,-1)压入栈顶
*@author lixiaobin
*/
public class LCMP extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Long v2 = visitor.getFrame().getStack().popLong();
        Long v1 = visitor.getFrame().getStack().popLong();
        if(v1 > v2){
            visitor.getFrame().getStack().pushInt(1);
        }else if (v1 == v2){
            visitor.getFrame().getStack().pushInt(0);
        }else{
            visitor.getFrame().getStack().pushInt(-1);
        }
    }
}
