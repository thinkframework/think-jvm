package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_NameAndType_info
 * @see org.apache.bcel.classfile.ConstantNameAndType
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_NameAndType_info extends CPInfo {
    private int name_index;
    private int type_index;
    public CONSTANT_NameAndType_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException{
        super(constantPool,CONSTANT_NameAndType);
        this.name_index = classFileReader.readUnsignedShort();
        this.type_index = classFileReader.readUnsignedShort();
    }

    public int getName_index() {
        return name_index;
    }

    public void setName_index(int name_index) {
        this.name_index = name_index;
    }

    public int getType_index() {
        return type_index;
    }

    public void setType_index(int type_index) {
        this.type_index = type_index;
    }

    @Override
    public Object getConstantValue() {
        return null;
    }
    @Override
    public String toString() {
        return cp.get(name_index).toString() + " " + cp.get(type_index).toString();
    }

    public String getName(){
        return cp.get(name_index).toString();
    }


    public String getType(){
        return cp.get(type_index).toString();
    }
}
