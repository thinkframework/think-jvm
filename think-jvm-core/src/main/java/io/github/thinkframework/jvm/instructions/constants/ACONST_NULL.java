package io.github.thinkframework.jvm.instructions.constants;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;

/*
*将null推送至栈顶
*@author lixiaobin
*/
public class ACONST_NULL extends NoOperandsInstruction {
	@Override
	public void execute(Visitor visitor){
		super.execute(visitor);
		visitor.getFrame().getStack().pushRef(null);
	}
}
