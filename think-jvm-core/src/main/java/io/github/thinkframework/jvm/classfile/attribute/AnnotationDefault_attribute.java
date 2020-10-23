package io.github.thinkframework.jvm.classfile.attribute;

import io.github.thinkframework.jvm.classfile.Attribute;
import io.github.thinkframework.jvm.classfile.ClassFileReader;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.AnnotationDefault_attribute
 * @see org.apache.bcel.classfile.AnnotationDefault
 * * @author lixiaobin
 * @since 2017/3/22.
 */
public class AnnotationDefault_attribute extends Attribute {
    public AnnotationDefault_attribute(ClassFileReader classFileReader, int attribute_name_index, int attribute_length) throws IOException {
        super(attribute_name_index,attribute_length);
    }
}
