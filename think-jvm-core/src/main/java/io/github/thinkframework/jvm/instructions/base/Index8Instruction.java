package io.github.thinkframework.jvm.instructions.base;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

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
