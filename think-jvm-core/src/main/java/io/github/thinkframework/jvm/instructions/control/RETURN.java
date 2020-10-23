package io.github.thinkframework.jvm.instructions.control;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*从当前方法返回void
*@author lixiaobin
*/
public class RETURN extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        visitor.getFrame().getThread().popFrame();
    }
}
