package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_Fieldref_info
 * @see org.apache.bcel.classfile.ConstantFieldref
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_Fieldref_info extends CPRefInfo {
    public CONSTANT_Fieldref_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException {
        super(constantPool, classFileReader, CPInfo.CONSTANT_Fieldref);
    }
}
