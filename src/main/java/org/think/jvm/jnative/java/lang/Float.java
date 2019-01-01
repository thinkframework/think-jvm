package org.think.jvm.jnative.java.lang;

import org.think.jvm.jnative.Registry;
import org.think.jvm.rtad.Frame;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class Float {
    public Float(){
        init();

    }

    public static void init(){
        Registry.getInstance().register("java/lang/Float","floatToRawIntBits","(F)I",frame -> floatToRawIntBits(frame));
    }

    public static void floatToRawIntBits(Frame frame){
        java.lang.Float value = frame.getLocalVars().getFloat(0);
        frame.getStack().pushInt(java.lang.Float.floatToRawIntBits(value));
    }
}
