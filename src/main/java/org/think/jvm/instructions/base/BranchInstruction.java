package org.think.jvm.instructions.base;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.Visitor;

/**
 * unit16整数
 * @author lixiaobin
 * @since
 * @author lixiaobin
 * @since 2017/3/24
 */
public class BranchInstruction extends Instruction {
    protected Integer offset;
    public void accept(Visitor visitor){
        super.accept(visitor);
        offset = visitor.readInt16();
    }

    protected void branch(Visitor visitor){
        Integer pc = visitor.getFrame().getThread().getPC();
        Integer nextPC = pc + offset;
        if(nextPC > 255){
            nextPC = 4;
        }
        visitor.getFrame().setNextPC(nextPC);
    }
}
