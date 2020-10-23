package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CPRefInfo
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CPRefInfo extends CPInfo {
    protected int class_index;
    protected int name_and_type_index;


    protected CPRefInfo(ConstantPool constantPool, ClassFileReader classFileReader, int tag) throws IOException {
        super(constantPool,tag);
        this.class_index = classFileReader.readUnsignedShort();
        this.name_and_type_index = classFileReader.readUnsignedShort();
    }

    public String getClassName(){
        return cp.get(class_index).toString();
    }

    public String getName(){
        CONSTANT_NameAndType_info constantNameAndTypeInfo = (CONSTANT_NameAndType_info)cp.get(name_and_type_index);
        return constantNameAndTypeInfo.getName();
    }


    public String getType(){
        CONSTANT_NameAndType_info constantNameAndTypeInfo = (CONSTANT_NameAndType_info)cp.get(name_and_type_index);
        return constantNameAndTypeInfo.getType();
    }

    @Override
    public Object getConstantValue() {
        return cp.get(class_index);
    }
    @Override
    public String toString() {
        return cp.get(class_index).toString() + "."+ cp.get(name_and_type_index).toString();
    }
}
