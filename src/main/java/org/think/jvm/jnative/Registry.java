package org.think.jvm.jnative;

import org.think.jvm.rtad.heap.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaobin
 * @since 2017/3/31
 */
public class Registry {
    Map<String,Object> map = new HashMap<String,Object>();
    public void register(String className, String methodName,String descriptor, Method method){
        String key = className+"~"+methodName+"~"+descriptor;
        map.put(key,method);
    }

    public Object findMehtod(String className, String methodName,String descriptor){
        String key = className+"~"+methodName+"~"+descriptor;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if("registerNatives".equals(methodName)){

        }
        return null;
    }
}
