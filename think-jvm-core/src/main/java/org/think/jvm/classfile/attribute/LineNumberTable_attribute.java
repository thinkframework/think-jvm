package org.think.jvm.classfile.attribute;

import org.think.jvm.classfile.Attribute;
import org.think.jvm.classfile.ClassFileReader;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @see com.sun.tools.classfile.LineNumberTable_attribute
 * @author lixiaobin
 * @since 2017/3/24
 */
public class LineNumberTable_attribute extends Attribute {

    public LineNumberTable_attribute(ClassFileReader classFileReader, int attribute_name_index, int attribute_length) throws IOException {
        super(attribute_name_index,attribute_length);
    }
//    @Override
//    public void read() throws IOException {
//        classFile.getInputStream().read(attribute_length);
//        classFile.getInputStream().read(line_number_table_length);
//        int codeLenth = ByteUtils.u2toint(line_number_table_length);
//        line_number_table = new Line_number_table[codeLenth];
//        for (int i=0;i<codeLenth;i++){
//            line_number_table[i] = new Line_number_table();
//            line_number_table[i].read(classFile.getInputStream());
//        }
//    }

    class Line_number_table{
        byte[] start_pc = new byte[2];
        byte[] line_number = new byte[2];
        public void read(DataInputStream inputStream) throws IOException {
            inputStream.read(start_pc);
            inputStream.read(line_number);
        }
    }
}

