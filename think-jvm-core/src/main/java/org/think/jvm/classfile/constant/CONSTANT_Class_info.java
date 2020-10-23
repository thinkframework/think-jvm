package org.think.jvm.classfile.constant;

import org.think.jvm.classfile.CPInfo;
import org.think.jvm.classfile.ClassFileReader;
import org.think.jvm.classfile.ConstantPool;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool.CONSTANT_Class_info
 * @see org.apache.bcel.classfile.ConstantClass
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CONSTANT_Class_info extends CPInfo {
    private int name_index;

    public CONSTANT_Class_info(ConstantPool constantPool, ClassFileReader classFileReader) throws IOException{
        super(constantPool,CONSTANT_Class);
        this.name_index = classFileReader.readUnsignedShort();
    }

    @Override
    public Object getConstantValue() {
        return cp.get(name_index);
    }

    @Override
    public String toString() {
        return cp.get(name_index).toString();
    }

}
