package io.github.thinkframework.jvm.jnative;

import io.github.thinkframework.jvm.jnative.java.lang.Class;
import io.github.thinkframework.jvm.jnative.java.lang.InvokeMethod;
import io.github.thinkframework.jvm.jnative.java.lang.Object;
import io.github.thinkframework.jvm.jnative.java.lang.Throwable;
import io.github.thinkframework.jvm.rtad.Frame;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class Registry {
    Map<String,InvokeMethod> map = new HashMap<String,InvokeMethod>();

    private static Registry instance;

    private Registry(){
    }

    public static Registry getInstance() {
        if(instance == null){
            instance = new Registry();

        }
        return instance;
    }

    public void init(){
        Class.init();
        Object.init();
        Throwable.init();
//        System.init();
    }

    public void register(String className, String methodName,String descriptor, InvokeMethod method){
        String key = className+"~"+methodName+"~"+descriptor;
        map.put(key,method);
    }

    /**
     * 查找本地方法
     * @param className 类名
     * @param methodName 方法名
     * @param descriptor 方法描述符
     * @return 本地方法
     */
    public InvokeMethod findNativeMehtod(String className, String methodName,String descriptor){
        String key = className+"~"+methodName+"~"+descriptor;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if("registerNatives".equals(methodName)){
            return new InvokeMethod() {
                @Override
                public void invoke(Frame frame) {
                    //empty;
                }
            };
        }
        return null;
    }
}
