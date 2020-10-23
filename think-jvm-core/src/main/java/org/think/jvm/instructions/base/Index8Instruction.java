package org.think.jvm.instructions.base;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.Instruction;

/**
 * unit8整数
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Index8Instruction extends Instruction {
    protected Integer index;
    public void accept(Visitor visitor){
        super.accept(visitor);
        index = visitor.readUInt8();
    }
}
