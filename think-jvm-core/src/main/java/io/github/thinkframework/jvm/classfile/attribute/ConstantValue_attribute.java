package io.github.thinkframework.jvm.classfile.attribute;

import io.github.thinkframework.jvm.classfile.Attribute;
import io.github.thinkframework.jvm.classfile.ClassFileReader;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantValue_attribute
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ConstantValue_attribute extends Attribute {
    private Integer constantvalue_index;

    public ConstantValue_attribute(ClassFileReader classFileReader, int attribute_name_index, int attribute_length) throws IOException {
        super(attribute_name_index,attribute_length);
        constantvalue_index = classFileReader.readUnsignedShort();
    }

    public Integer getConstantvalueIndex(){
        return constantvalue_index;
    }
//    @Override
//    public void read() throws IOException {
//        classFile.getInputStream().read(attribute_length);
//        int length = ByteUtils.getInt(attribute_length);
//        classFile.getInputStream().read(constantvalue_index);
//    }
}

