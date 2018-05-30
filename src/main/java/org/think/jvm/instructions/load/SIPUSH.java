package org.think.jvm.instructions.load;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.Visitor;

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
//		visitor.getFrame().getStack().pushInt(value);
	}
}
