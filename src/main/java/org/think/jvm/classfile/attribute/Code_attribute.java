package org.think.jvm.classfile.attribute;

import org.think.jvm.classfile.Attribute;
import org.think.jvm.classfile.Attributes;
import org.think.jvm.classfile.ClassFileReader;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.Code_attribute
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Code_attribute extends Attribute {
    private final int max_stack;
    private final int max_locals;
    private final int code_length;
    private final byte[] code;
    private final int exception_table_length;
    private final Exception_data[] exception_table;
    private final Attributes attributes;


    public Code_attribute(ClassFileReader classFileReader, int attribute_name_index, int attribute_length) throws IOException {
        super(attribute_name_index,attribute_length);
        this.max_stack = classFileReader.readUnsignedShort();
        this.max_locals = classFileReader.readUnsignedShort();
        this.code_length = classFileReader.readInt();
        this.code = new byte[this.code_length];
        classFileReader.readFully(this.code);
        this.exception_table_length = classFileReader.readUnsignedShort();
        this.exception_table = new Exception_data[this.exception_table_length];

        for(int var4 = 0; var4 < this.exception_table_length; ++var4) {
            this.exception_table[var4] = new Exception_data(classFileReader);
        }

        this.attributes = new Attributes(classFileReader);
    }

    public int getMax_stack() {
        return max_stack;
    }

    public int getMax_locals() {
        return max_locals;
    }

    public int getCode_length() {
        return code_length;
    }

    public byte[] getCode() {
        return code;
    }

    public int getException_table_length() {
        return exception_table_length;
    }

    public Exception_data[] getException_table() {
        return exception_table;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    class Exception_data{
        public final int start_pc;
        public final int end_pc;
        public final int handler_pc;
        public final int catch_type;

        Exception_data(ClassFileReader var1) throws IOException {
            this.start_pc = var1.readUnsignedShort();
            this.end_pc = var1.readUnsignedShort();
            this.handler_pc = var1.readUnsignedShort();
            this.catch_type = var1.readUnsignedShort();
        }
    }
}


