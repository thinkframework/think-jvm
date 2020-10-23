package io.github.thinkframework.jvm.rtad.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串池
 * @author lixiaobin
 * @since 2017/3/29
 */
public class StringPool {
    Map<String,String> map = new HashMap<String,String>();

    private static StringPool instance;

    private StringPool(){

    }

    public static StringPool getInstance() {
        if(instance == null){
            instance = new StringPool();

        }
        return instance;
    }

    public String JString(ClazzLoader clazzLoader,String key){
        if(map.containsKey(key)){
            return map.get(key);
        }
        //TODO 字符串池
//        ClassObject classObject = clazzLoader.loadClass("java/lang/String").newObject();

        map.put(key,new String(key.toCharArray()));
        return map.get(key);
    }

    public static String intern(){
        return null;
    }
}
