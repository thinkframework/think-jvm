package io.github.thinkframework.jvm.instructions.control;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;
import io.github.thinkframework.jvm.rtad.Frame;

/*
*从当前方法返回int
*@author lixiaobin
*/
public class IRETURN extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Frame currentFrame = visitor.getFrame().getThread().popFrame();
        Frame invokerFrame = visitor.getFrame().getThread().topFrame();

        Integer retVal = (int)currentFrame.getStack().popInt();
        invokerFrame.getStack().pushInt(retVal);
    }
}
