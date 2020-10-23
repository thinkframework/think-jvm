package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_Double_info
 * @see org.apache.bcel.classfile.ConstantDouble
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_Double_info extends CPInfo {
    private Double value;

    public CONSTANT_Double_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException {
        super(constantPool,CONSTANT_Double);
        value = classFileReader.readDouble();
    }

    @Override
    public Object getConstantValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
