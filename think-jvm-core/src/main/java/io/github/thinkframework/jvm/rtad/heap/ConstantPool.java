package io.github.thinkframework.jvm.rtad.heap;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ConstantPool {
    private Clazz clazz;
    private Constant[] constants;

    public ConstantPool(){

    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Constant[] getConstants() {
        return constants;
    }

    public void setConstants(Constant[] constants) {
        this.constants = constants;
    }

    public ConstantPool(Clazz clazz, Integer lenght){
        this.clazz = clazz;
        this.constants = new Constant[lenght];
    }

    public Constant getConstant(Integer index){

        return constants[index] == null ? new Constant() : constants[index];
    }


    public void setConstant(Integer index,Constant constant){
        this.constants[index] = constant;
    }
}
