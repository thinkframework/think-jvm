package io.github.thinkframework.jvm.instructions.constants;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将double型0推送至栈顶
*@author lixiaobin
*/
public class DCONST_0 extends NoOperandsInstruction {
	@Override
	public void execute(Visitor visitor){
		super.execute(visitor);
		visitor.getFrame().getStack().pushDouble(0d);
	}
}
