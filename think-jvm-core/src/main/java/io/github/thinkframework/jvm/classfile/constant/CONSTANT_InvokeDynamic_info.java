package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * JDK 1.7
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_InvokeDynamic_info
 * @see org.apache.bcel.classfile.ConstantInvokeDynamic
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_InvokeDynamic_info extends CPInfo {
    private int bootstrap_method_attr_index;
    private int name_and_type_index;
    public CONSTANT_InvokeDynamic_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException{
        super(constantPool,CONSTANT_InvokeDynamic);
        this.bootstrap_method_attr_index = classFileReader.readUnsignedShort();
        this.name_and_type_index = classFileReader.readUnsignedShort();
    }

    @Override
    public Object getConstantValue() {
        return null;
    }
}
