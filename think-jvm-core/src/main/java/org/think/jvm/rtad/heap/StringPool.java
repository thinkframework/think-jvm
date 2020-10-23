package org.think.jvm.rtad.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaobin
 * @since 2017/3/29
 */
public class StringPool {
    Map<String,String> map = new HashMap<String,String>();

    public void JString(ClazzLoader clazzLoader,String key){
        String s = "";
        if(map.containsKey(key)){
//            return map.get(key);
        }
        
    }
}
