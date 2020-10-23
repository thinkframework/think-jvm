package io.github.thinkframework.jvm.classfile.attribute;

import io.github.thinkframework.jvm.classfile.Attribute;
import io.github.thinkframework.jvm.classfile.ClassFileReader;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.Exceptions_attribute
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Exceptions_attribute extends Attribute {
    private byte[] number_of_exceptions = new byte[2];
    private byte[][] exception_index_table;// = new byte[4][];


    public Exceptions_attribute(ClassFileReader classFileReader, int attribute_name_index, int attribute_length) throws IOException {
        super(attribute_name_index,attribute_length);
    }
//    @Override
//    public void read() throws IOException {
//        classFile.getInputStream().read(attribute_length);
//        classFile.getInputStream().read(number_of_exceptions);
//        int length = ByteUtils.u2toint(number_of_exceptions);
//        exception_index_table = new byte[length][2];
//        for (int i=0;i<length;i++){
//            exception_index_table[i] = new byte[2];
//            classFile.getInputStream().read(exception_index_table[i]);
//        }
//    }

//    @Override
//    public String toString() {
//        CONSTANT_Utf_8 constant_utf_8 = (CONSTANT_Utf_8)constant_pool[ByteUtils.u2toint(sourcefile_index)];
//        return constant_utf_8.toString();
//    }
}

