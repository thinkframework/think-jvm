package io.github.thinkframework.jvm.instructions.extended;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;
import io.github.thinkframework.jvm.instructions.InstructionFactory;

/*
*扩展访问局部变量表的索引宽度
*@author lixiaobin
*/
public class WIDE extends Instruction {
    Instruction modifiedInstruction;

    public void accept(Visitor visitor){
        super.accept(visitor);
        visitor.skipPadding();
        Integer opcode = visitor.readUInt8();
        modifiedInstruction = InstructionFactory.newInstruction(opcode);
        modifiedInstruction.accept(visitor);
    }

    public void execute(Visitor visitor){
        super.execute(visitor);
        modifiedInstruction.execute(visitor);
    }
}
