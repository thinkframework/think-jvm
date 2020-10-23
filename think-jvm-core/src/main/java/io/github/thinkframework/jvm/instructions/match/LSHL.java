package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将long型数值左移位指定位数并将结果压入栈顶
*@author lixiaobin
*/
public class LSHL extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Integer v2 = visitor.getFrame().getStack().popInt();
        Long v1 = visitor.getFrame().getStack().popLong();
        Long result = v1 << v2;
        visitor.getFrame().getStack().pushLong(result);
    }
}
