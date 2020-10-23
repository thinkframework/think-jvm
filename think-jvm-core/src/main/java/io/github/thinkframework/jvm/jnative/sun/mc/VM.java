package io.github.thinkframework.jvm.jnative.sun.mc;

import io.github.thinkframework.jvm.rtad.Frame;
import io.github.thinkframework.jvm.rtad.Solt;
import io.github.thinkframework.jvm.rtad.Thread;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ClazzLoader;
import io.github.thinkframework.jvm.rtad.heap.Method;

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
