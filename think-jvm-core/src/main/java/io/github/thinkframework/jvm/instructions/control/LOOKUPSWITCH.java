package io.github.thinkframework.jvm.instructions.control;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

/*
*用于switch条件跳转,case值不连续(可变长度指令)
*@author lixiaobin
*/
public class LOOKUPSWITCH extends Instruction {

    Integer offset;
    int defaultOffset;
    int npairs;
    int[] jumpOffsets;

    public void accept(Visitor visitor){
        super.accept(visitor);
        visitor.skipPadding();
        defaultOffset = visitor.readInt32();
        npairs = visitor.readInt32();
        int count = npairs * 2;
        jumpOffsets = new int[count];
        for(int i=0;i<count;i++){
            jumpOffsets[i] = visitor.readInt32();
        }
    }
    public void execute(Visitor visitor){
        super.execute(visitor);
        Integer index = visitor.getFrame().getStack().popInt();
         for(int i=0;i<npairs*2;i+=2){
             if(jumpOffsets[i] == index){
                 offset = jumpOffsets[i+1];
                 branch(visitor);
                 return;
             }
         }
         offset = defaultOffset;
        branch(visitor);
    }

    protected void branch(Visitor visitor){
        Integer pc = visitor.getFrame().getThread().getPC();
        Integer nextPC = pc + offset;
        visitor.getFrame().setNextPC(nextPC);
    }
}
