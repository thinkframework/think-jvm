package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_Methodref_info
 * @see org.apache.bcel.classfile.ConstantMethodref
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_Methodref_info extends CPRefInfo {
    public CONSTANT_Methodref_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException {
        super(constantPool, classFileReader, CPInfo.CONSTANT_Methodref);
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
