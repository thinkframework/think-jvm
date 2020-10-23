package io.github.thinkframework.jvm.rtad.heap;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassObject {
    private Clazz clazz;
    private Object fields;
    private Object extra;
    public ClassObject(){

    }

    public ClassObject(Clazz clazz, int instanceSlotCount){
        this.clazz = clazz;
        fields = new Solts(instanceSlotCount);
    }

    public Boolean isInstanceOf(Clazz clazz){
        return clazz.isAssignableFrom(this.clazz);
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Solts getFields() {
        return (Solts)fields;
    }

    public void setFields(Solts fields) {
        this.fields = fields;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

//    @Override
//    public String toString() {
//        return fields.toString();
//    }
}
