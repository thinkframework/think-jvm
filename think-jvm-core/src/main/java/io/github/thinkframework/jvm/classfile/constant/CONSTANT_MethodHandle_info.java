package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * JDK 1.7
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_MethodHandle_info
 * @see org.apache.bcel.classfile.ConstantMethodHandle
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_MethodHandle_info extends CPInfo {
    private int reference_kind;
    private int reference_index;
    private byte[] bytes = new byte[8];
    public CONSTANT_MethodHandle_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException{
        super(constantPool,CONSTANT_MethodHandle);
        this.reference_kind = classFileReader.readUnsignedByte();
        this.reference_index = classFileReader.readUnsignedShort();
    }

    @Override
    public Object getConstantValue() {
        return null;
    }
}
