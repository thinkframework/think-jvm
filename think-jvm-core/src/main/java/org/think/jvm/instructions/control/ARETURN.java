package org.think.jvm.instructions.control;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.Frame;

/*
*从当前方法返回对象引用
*@author lixiaobin
*/
public class ARETURN extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Frame currentFrame = visitor.getFrame().getThread().popFrame();
        Frame invokerFrame = visitor.getFrame().getThread().topFrame();
        Object retVal = currentFrame.getStack().popRef();
        invokerFrame.getStack().pushRef(retVal);
    }
}
