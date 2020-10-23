package io.github.thinkframework.jvm.rtad.heap;


/**
 * @see com.sun.tools.classfile.ConstantPool.CPInfo
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Constant {
    public static final int CONSTANT_Utf8 = 1;
    public static final int CONSTANT_Integer = 3;
    public static final int CONSTANT_Float = 4;
    public static final int CONSTANT_Long = 5;
    public static final int CONSTANT_Double = 6;
    public static final int CONSTANT_Class = 7;
    public static final int CONSTANT_String = 8;
    public static final int CONSTANT_Fieldref = 9;
    public static final int CONSTANT_Methodref = 10;
    public static final int CONSTANT_InterfaceMethodref = 11;
    public static final int CONSTANT_NameAndType = 12;
    public static final int CONSTANT_MethodHandle = 15;
    public static final int CONSTANT_MethodType = 16;
    public static final int CONSTANT_InvokeDynamic = 18;
    protected ConstantPool cp;
    protected int tag;
    protected java.lang.Object object;
    protected Number value;
    public Constant(){
    }

    public Constant(ConstantPool cp) {
        this.cp = cp;
    }

    public Constant(int tag){
        this.tag = tag;
    }

    public Constant(int tag,java.lang.Object object){
        this.tag = tag;
        this.object = object;
    }

    public Constant(int tag,Number value){
        this.tag = tag;
        this.value = value;
    }

//    public abstract void read() throws IOException;


    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }
}
