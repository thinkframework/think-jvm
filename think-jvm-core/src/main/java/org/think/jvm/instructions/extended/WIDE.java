package org.think.jvm.instructions.extended;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.InstructionFactory;

/*
*扩展访问局部变量表的索引宽度
*@author lixiaobin
*/
public class WIDE extends Instruction {
    Instruction modifiedInstruction;

    public void accept(org.think.jvm.Visitor visitor){
        super.accept(visitor);
        visitor.skipPadding();
        Integer opcode = visitor.readUInt8();
        modifiedInstruction = InstructionFactory.newInstruction(opcode);
        modifiedInstruction.accept(visitor);
    }

    public void execute(org.think.jvm.Visitor visitor){
        super.execute(visitor);
        modifiedInstruction.execute(visitor);
    }
}
