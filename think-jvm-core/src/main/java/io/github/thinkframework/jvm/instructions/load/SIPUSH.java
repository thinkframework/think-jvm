package io.github.thinkframework.jvm.instructions.load;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.Instruction;

/*
*将一个短整型常量值(-32768~32767)推送至栈顶
*@author lixiaobin
*/
public class SIPUSH extends Instruction {
	int value;
	@Override
	public void accept(Visitor visitor){
		value = visitor.readUInt16();
	}

	public void execute(Visitor visitor){
		visitor.getFrame().getStack().pushInt(value);
	}
}
