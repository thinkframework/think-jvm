package org.think.jvm.instructions.reserved;

import org.think.jvm.exceptions.VMException;
import org.think.jvm.instructions.base.NoOperandsInstruction;
import org.think.jvm.jnative.Registry;
import org.think.jvm.jnative.java.lang.InvokeMethod;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.heap.Method;

/*
*用于在特定硬件中使用的语言后门
*@author lixiaobin
*/
public class IMPDEP1 extends NoOperandsInstruction {
    @Override
    public void execute(org.think.jvm.Visitor visitor){
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
