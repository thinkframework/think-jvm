package org.think.jvm.rtad.heap;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Solt {
    private Object value;
    public Solt(Object value){
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

//    @Override
//    public String toString() {
//        return value.toString();
//    }
}
