package org.think.jvm.instructions.match;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;

/*
*将指定int型变量增加指定值
*@author lixiaobin
*/
public class IINC extends Instruction {
    Integer index;
    Integer _const;
    @Override
    public void accept(org.think.jvm.Visitor visitor){
        index = visitor.readInt8();
        _const = visitor.readInt8();
    }

    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Integer value = visitor.getFrame().getLocalVars().getInt(index);
        Integer result = value + _const;
        visitor.getFrame().getLocalVars().setInt(index,result);
    }
}