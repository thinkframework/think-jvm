package io.github.thinkframework.jvm.classfile.attribute;

import io.github.thinkframework.jvm.classfile.Attribute;
import io.github.thinkframework.jvm.classfile.ClassFileReader;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.SourceFile_attribute
 * @author lixiaobin
 * @since 2017/3/24
 */
public class SourceFile_attribute extends Attribute {
    private byte[] sourcefile_index = new byte[2];

    public SourceFile_attribute(ClassFileReader classFileReader, int attribute_name_index, int attribute_length) throws IOException {
        super(attribute_name_index,attribute_length);
    }

}

