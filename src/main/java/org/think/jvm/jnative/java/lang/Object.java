package org.think.jvm.jnative.java.lang;

import org.think.jvm.jnative.Registry;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.heap.ClassObject;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class Object {
    public Object(){
        init();

    }

    public static void init(){
        Registry.getInstance().register("java/lang/Object","getClass","()Ljava/lang/Class;",frame -> getClass(frame));
        Registry.getInstance().register("java/lang/Object","hashCode","()I",frame -> hashCode(frame));
        Registry.getInstance().register("java/lang/Object","clone","()Ljava/lang/Class;",frame -> clone(frame));
    }

    public static void getClass(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }



    public static void hashCode(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushInt(0);
    }


    public static void clone(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }
}
