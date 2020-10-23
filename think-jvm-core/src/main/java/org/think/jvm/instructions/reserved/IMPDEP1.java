package org.think.jvm.instructions.reserved;

import org.think.jvm.instructions.Instruction;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.ClassRef;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ConstantPool;
import org.think.jvm.rtad.heap.Method;

/*
*用于在特定硬件中使用的语言后门
*@author lixiaobin
*/
public class IMPDEP1 extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
        Method method = visitor.getFrame().getMethod();
        String className = method.getClazz().getName();
        String methodName = method.getName();
        String descriptor = method.getDescriptor();
    }
}
