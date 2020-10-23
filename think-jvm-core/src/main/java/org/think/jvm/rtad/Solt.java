package org.think.jvm.rtad;


/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Solt {
    private Object value;
    private Boolean w = false;//long double长度的问题
    public Solt(Object value){
        this.value = value;
    }


    public Solt(Object value,Boolean w){
        this.value = value;
        this.w = w;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Boolean getW() {
        return w;
    }

    public void setW(Boolean w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return value == null ? "" : value.toString();
    }
}
