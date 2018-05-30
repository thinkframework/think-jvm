package org.think.jvm.instructions.control;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.Frame;

/*
*从当前方法返回long
*@author lixiaobin
*/
public class LRETURN extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Frame currentFrame = visitor.getFrame().getThread().popFrame();
        Frame invokerFrame = visitor.getFrame().getThread().topFrame();
        Long retVal = currentFrame.getStack().popLong();
        invokerFrame.getStack().pushLong(retVal);
    }
}