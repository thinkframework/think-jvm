package io.github.thinkframework.jvm.instructions.comparison;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*比较栈顶两float型数值大小,并将结果(1,0,-1)压入栈顶;当其中一个数值为“NaN”时,将1压入栈顶
*@author lixiaobin
*/
public class FCMPG extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Float v2 = visitor.getFrame().getStack().popFloat();
        Float v1 = visitor.getFrame().getStack().popFloat();
        if(v1 > v2){
            visitor.getFrame().getStack().pushInt(1);
        }else if (v1 == v2){
            visitor.getFrame().getStack().pushInt(0);
        }else if (v1 < v2){
            visitor.getFrame().getStack().pushInt(-1);
        }else{
            visitor.getFrame().getStack().pushInt(1);
        }
    }
}
