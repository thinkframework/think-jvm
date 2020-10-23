package org.think.jvm.jnative.sun.mc;

import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.Solt;
import org.think.jvm.rtad.Thread;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ClazzLoader;
import org.think.jvm.rtad.heap.Method;

/**
 * @author lixiaobin
 * @since 2017/3/30
 */
public class VM {
    public void initialize(Frame frame){
        ClazzLoader clazzLoader = frame.getMethod().getClazz().getClazzLoader();
        Clazz system = clazzLoader.loadClass("java/lang.System");
        system.getStaticMethod("initializeSystemClass","()V");
//        invokeMethod();
    }


    public void invokeMethod(Frame invokerFrame, Method method){
        Thread thread = invokerFrame.getThread();
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(newFrame);
        int argSlotSlot = method.getArgSlotcount();
        if(argSlotSlot > 0) {
            for (int i = argSlotSlot - 1; i >= 0; i--) {
                Solt solt = invokerFrame.getStack().popSolt();
                newFrame.getLocalVars().setSolt(i, solt);
            }
        }
        if(method.getAccessFlags().isNative() || "registerNatives".equals(method.getName())){
            thread.popFrame();
        }
    }
}
