package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.Frame;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ConstantPool;
import io.github.thinkframework.jvm.rtad.heap.Method;
import io.github.thinkframework.jvm.rtad.heap.MethodRef;

/*
*调用静态方法
*@author lixiaobin
*/
public class INVOKESTATIC extends Index16Instruction {

    @Override
    public void execute(Visitor visitor) {
        Frame frame = visitor.getFrame();
        ConstantPool constantPool = frame.getMethod().getClazz().getConstantPool();
        MethodRef methodRef = (MethodRef)constantPool.getConstant(index);
        Method method = methodRef.resolvedMethod();
        Clazz clazz = method.clazz;
        if(!clazz.getInitStared()){
            visitor.getFrame().revertNextPc();
            clazz.init(visitor.getFrame().getThread(),clazz);
            return;
        }
        super.execute(visitor);
        invokeMethod(frame,method);
    }
}
