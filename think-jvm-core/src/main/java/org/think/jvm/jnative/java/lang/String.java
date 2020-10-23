package org.think.jvm.jnative.java.lang;

import org.think.jvm.jnative.Registry;
import org.think.jvm.rtad.Frame;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class String {
    public String(){
        init();

    }

    public static void init(){
        Registry.getInstance().register("java/lang/String","intern","(F)Ljava.lang.String",frame -> intern(frame));
    }

    public static void intern(Frame frame){
        java.lang.Object object = frame.getLocalVars().getRef(0);
        frame.getStack().pushRef(object);
    }
}
