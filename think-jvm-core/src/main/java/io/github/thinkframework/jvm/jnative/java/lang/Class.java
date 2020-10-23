package io.github.thinkframework.jvm.jnative.java.lang;

import io.github.thinkframework.jvm.jnative.Registry;
import io.github.thinkframework.jvm.rtad.Frame;
import io.github.thinkframework.jvm.rtad.heap.ClassObject;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ClazzLoader;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class Class {
    public Class(){
        init();

    }

    public static void init(){
        Registry.getInstance().register("java/lang/Class", "getPrimitiveClass", "(Ljava/lang/String;)Ljava/lang/Class;", frame -> getPrimitiveClass(frame));
        Registry.getInstance().register("java/lang/Class","getName0","()Ljava/lang/String;",frame -> getName0(frame));
        Registry.getInstance().register("java/lang/Class","desiredAssertionStatus0","(Ljava/lang/Class;)Z",frame -> desiredAssertionStatus0(frame));
    }

    public static void getPrimitiveClass(Frame frame){
        java.lang.String name = (java.lang.String)frame.getLocalVars().getRef(0);
        ClazzLoader clazzLoader = frame.getMethod().getClazz().getClazzLoader();
        ClassObject classObject = clazzLoader.loadClass(name).getClazzObject();
        frame.getStack().pushRef(classObject);
    }

    public static void getName0(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        Clazz clazz = (Clazz)object.getExtra();
        java.lang.String javaName = clazz.javaName();
        frame.getStack().pushRef(javaName);
    }


    public static void desiredAssertionStatus0(Frame frame){
        frame.getStack().pushInt(0);
    }
}
