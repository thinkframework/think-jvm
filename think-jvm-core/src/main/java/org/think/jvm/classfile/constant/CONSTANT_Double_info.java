package org.think.jvm.classfile.constant;

import org.think.jvm.classfile.ClassFileReader;
import org.think.jvm.classfile.CPInfo;
import org.think.jvm.classfile.ConstantPool;

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
