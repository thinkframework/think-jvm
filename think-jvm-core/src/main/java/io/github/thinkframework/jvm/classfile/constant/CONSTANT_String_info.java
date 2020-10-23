package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_String_info
 * @see org.apache.bcel.classfile.ConstantString
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_String_info extends CPInfo {
    private int string_index;
    public CONSTANT_String_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException{
        super(constantPool,CONSTANT_String);
        this.string_index = classFileReader.readUnsignedShort();
    }

    @Override
    public Object getConstantValue() {
        return cp.get(string_index);
    }

    @Override
    public String toString() {
        return cp.get(string_index).toString();
    }
}
