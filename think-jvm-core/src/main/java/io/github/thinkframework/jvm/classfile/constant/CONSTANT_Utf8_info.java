package io.github.thinkframework.jvm.classfile.constant;

import io.github.thinkframework.jvm.classfile.CPInfo;
import io.github.thinkframework.jvm.classfile.ClassFileReader;
import io.github.thinkframework.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_Utf8_info
 * @see org.apache.bcel.classfile.ConstantUtf8
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_Utf8_info extends CPInfo {
    private String value;

    public CONSTANT_Utf8_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException {
        super(CONSTANT_Utf8);
        this.value = classFileReader.readUTF();
    }

    @Override
    public Object getConstantValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
