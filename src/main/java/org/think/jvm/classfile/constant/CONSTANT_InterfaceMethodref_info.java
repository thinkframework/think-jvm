package org.think.jvm.classfile.constant;

import org.think.jvm.classfile.ClassFileReader;
import org.think.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_InterfaceMethodref_info
 * @see org.apache.bcel.classfile.ConstantInterfaceMethodref
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_InterfaceMethodref_info extends CPRefInfo {

    public CONSTANT_InterfaceMethodref_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException {
        super(constantPool, classFileReader, CONSTANT_InterfaceMethodref);
    }

}
