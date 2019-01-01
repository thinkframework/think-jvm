package org.think.jvm.instructions.load;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.Visitor;

/*
*将单字节的常量值(-128~127)推送至栈顶
*@author lixiaobin
*/
public class BIPUSH extends Instruction {
	Integer value;
	@Override
	public void accept(Visitor visitor){
		super.accept(visitor);
		value = visitor.readInt8();
	}

	public void execute(Visitor visitor){
		super.execute(visitor);
		visitor.getFrame().getStack().pushInt(value);
	}
}
