package org.think.jvm.instructions.extended;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;

/*
*无条件跳转(宽索引)
*@author lixiaobin
*/
public class GOTO_W extends Instruction {

    protected Integer offset;
    public void accept(Visitor visitor){
        super.accept(visitor);
        offset = visitor.readInt32();
    }

    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        branch(visitor);
    }

    protected void branch(Visitor visitor){
        Integer pc = visitor.getFrame().getThread().getPC();
        Integer nextPC = pc + offset;
        visitor.getFrame().setNextPC(nextPC);
    }

}
