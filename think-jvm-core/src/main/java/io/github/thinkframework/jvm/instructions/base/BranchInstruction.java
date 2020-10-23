package io.github.thinkframework.jvm.instructions.base;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

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
        visitor.getFrame().setNextPC(nextPC);
    }
}
