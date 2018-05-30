package org.think.jvm.instructions.references;

import org.think.jvm.Visitor;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.heap.ConstantPool;
import org.think.jvm.rtad.heap.Method;
import org.think.jvm.rtad.heap.MethodRef;

/*
*调用静态方法
*@author lixiaobin
*/
public class INVOKESTATIC extends Index16Instruction {

    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Frame frame = visitor.getFrame();
        ConstantPool constantPool = frame.getMethod().getClazz().getConstantPool();
        MethodRef methodRef = (MethodRef)constantPool.getConstant(index);
        Method method = methodRef.resolvedMethod();
        invokeMethod(frame,method);
    }
}
