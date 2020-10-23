package io.github.thinkframework.jvm.classfile.attribute;

import io.github.thinkframework.jvm.classfile.Attribute;
import io.github.thinkframework.jvm.classfile.ClassFileReader;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @see com.sun.tools.classfile.LocalVariableTable_attribute
 * @author lixiaobin
 * @since 2017/3/24
 */
public class LocalVariableTable_attribute extends Attribute {
    private byte[] local_variable_table_length = new byte[2];
    private Local_variable_table[] local_variable_table;

    public LocalVariableTable_attribute(ClassFileReader classFileReader, int attribute_name_index, int attribute_length) throws IOException {
        super(attribute_name_index,attribute_length);
    }
//    @Override
//    public void read() throws IOException {
//        classFile.getInputStream().read(attribute_length);
//        classFile.getInputStream().read(local_variable_table_length);
//        int codeLenth = ByteUtils.u2toint(local_variable_table_length);
//        local_variable_table = new Local_variable_table[codeLenth];
//        for (int i=0;i<codeLenth;i++){
//            local_variable_table[i] = new Local_variable_table();
//            local_variable_table[i].read(classFile.getInputStream());
//        }
//    }

    class Local_variable_table{
        byte[] start_pc = new byte[2];
        byte[] length = new byte[2];
        byte[] name_index = new byte[2];
        byte[] descriptor_index = new byte[2];
        byte[] index = new byte[2];
        public void read(DataInputStream inputStream) throws IOException {
            inputStream.read(start_pc);
            inputStream.read(length);
            inputStream.read(name_index);
            inputStream.read(descriptor_index);
            inputStream.read(index);
        }
    }
}

