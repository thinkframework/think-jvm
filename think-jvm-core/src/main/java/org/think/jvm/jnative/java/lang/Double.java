package org.think.jvm.jnative.java.lang;

import org.think.jvm.jnative.Registry;
import org.think.jvm.rtad.Frame;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class Double {
    public Double(){
        init();

    }

    public static void init(){
        Registry.getInstance().register("java/lang/Double","doubleToRawLongBits","(D)J",frame -> doubleToRawIntBits(frame));
    }

    public static void doubleToRawIntBits(Frame frame){
        java.lang.Double value = frame.getLocalVars().getDouble(0);
        frame.getStack().pushLong(java.lang.Double.doubleToRawLongBits(value));
    }
}
