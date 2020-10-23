package io.github.thinkframework.jvm.instructions.reserved;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.exceptions.VMException;
import io.github.thinkframework.jvm.instructions.base.NoOperandsInstruction;
import io.github.thinkframework.jvm.jnative.Registry;
import io.github.thinkframework.jvm.jnative.java.lang.InvokeMethod;
import io.github.thinkframework.jvm.rtad.Frame;
import io.github.thinkframework.jvm.rtad.heap.Method;

/*
*用于在特定硬件中使用的语言后门
*@author lixiaobin
*/
public class IMPDEP1 extends NoOperandsInstruction {
    @Override
    public void execute(Visitor visitor){
        super.execute(visitor);
        Frame frame = visitor.getFrame();
        Method method = frame.getMethod();
        String className = method.getClazz().getName();
        String methodName = method.getName();
        String methodDescriptor = method.getDescriptor();

        InvokeMethod invokeMethod = Registry.getInstance().findNativeMehtod(className,methodName,methodDescriptor);
        if(invokeMethod == null){
            throw new VMException("java.lang.UnsatisfieldLinkError");
        }
        invokeMethod.invoke(frame);
    }
}
