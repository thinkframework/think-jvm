package org.think.jvm.jnative.java.lang;

import org.think.jvm.jnative.Registry;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.heap.ClassObject;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class System {
    public System(){
        init();

    }

    public static void init(){
        Registry.getInstance().register("java/lang/System","arraycopy","(Ljava/lang/Object;ILjava/lang/Object;II)V;",frame -> arraycopy(frame));
        Registry.getInstance().register("java/lang/Object","hashCode","()I",frame -> hashCode(frame));
        Registry.getInstance().register("java/lang/Object","clone","()Ljava/lang/Class;",frame -> clone(frame));
        Registry.getInstance().register("java/lang/System","setIn0","()Ljava/lang/Class;",frame -> setIn0(frame));
        Registry.getInstance().register("java/lang/System","setOut0","()Ljava/lang/Class;",frame -> setOut0(frame));
        Registry.getInstance().register("java/lang/System","setErr0","()Ljava/lang/Class;",frame -> setErr0(frame));
    }

    public static void arraycopy(Frame frame){
//        java.lang.Object src = frame.getLocalVars().getRef(0);
//        Integer srcPos = frame.getLocalVars().getInt(1);
//        java.lang.Object dest = frame.getLocalVars().getRef(2);
//        Integer destPos = frame.getLocalVars().getInt(3);
//        Integer length = frame.getLocalVars().getInt(4);
//        ClassObject classObject = object.getClazz().getClazzObject();
//        frame.getStack().pushRef(classObject);
    }


    public static void getClass(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }



    public static void hashCode(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }


    public static void clone(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }

    public static void setIn0(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }

    public static void setOut0(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }


    public static void setErr0(Frame frame){
        ClassObject object = frame.getLocalVars().getThis();
        ClassObject classObject = object.getClazz().getClazzObject();
        frame.getStack().pushRef(classObject);
    }
}
