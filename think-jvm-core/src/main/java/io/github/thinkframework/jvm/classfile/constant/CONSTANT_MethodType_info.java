package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * JDK 1.7
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_MethodType_info
 * @see org.apache.bcel.classfile.ConstantMethodType
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_MethodType_info extends CPInfo {
    private int descriptor_index;
    public CONSTANT_MethodType_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException{
        super(constantPool,CONSTANT_MethodType);
        this.descriptor_index = classFileReader.readUnsignedShort();
    }

    @Override
    public Object getConstantValue() {
        return cp.get(descriptor_index);
    }

    @Override
    public String toString() {
        return cp.get(descriptor_index).toString();
    }
}
