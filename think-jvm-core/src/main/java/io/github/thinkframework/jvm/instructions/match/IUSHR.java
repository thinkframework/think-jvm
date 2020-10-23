package io.github.thinkframework.jvm.instructions.match;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将int型数值右(无符号)移位指定位数并将结果压入栈顶
*@author lixiaobin
*/
public class IUSHR extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Integer v2 = visitor.getFrame().getStack().popInt();
        Integer v1 = visitor.getFrame().getStack().popInt();
        Integer result = v1 >>> v2;
        visitor.getFrame().getStack().pushInt(result);
    }
}
