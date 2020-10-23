package org.think.jvm.instructions.control;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.base.BranchInstruction;

/*
*用于switch条件跳转,case值连续(可变长度指令)
*@author lixiaobin
*/
public class TABLESWITCH extends Instruction {
    Integer offset;
    int defaultOffset;
    int low;
    int high;
    int[] jumpOffsets;

    public void accept(org.think.jvm.Visitor visitor){
        super.accept(visitor);
        visitor.skipPadding();
        defaultOffset = visitor.readInt32();
        low = visitor.readInt32();
        high = visitor.readInt32();
        int count = high - low + 1;
        jumpOffsets = new int[count];
        for(int i=0;i<count;i++){
            jumpOffsets[i] = visitor.readInt32();
        }
    }
    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        Integer index = visitor.getFrame().getStack().popInt();
        if(index >= low && index <= high){
            offset = jumpOffsets[index-low];
        }else{
            offset = defaultOffset;
        }
        branch(visitor);
    }

    protected void branch(Visitor visitor){
        Integer pc = visitor.getFrame().getThread().getPC();
        Integer nextPC = pc + offset;
        visitor.getFrame().setNextPC(nextPC);
    }
}
