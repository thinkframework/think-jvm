package io.github.thinkframework.jvm.classfile;


import java.io.*;

/**
 * @see com.sun.tools.classfile.ClassReader,java.io.DataInput
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassFileReader implements DataInput{
    private DataInputStream in;
    private ClassFile classFile;
    private Attribute.Factory attributeFactory;

    public ClassFileReader(ClassFile classFile, InputStream in, Attribute.Factory attributeFactory){
        this.classFile = classFile;
        if(in instanceof DataInputStream) {
            this.in = (DataInputStream)in;
        }else{
            this.in = new DataInputStream(new BufferedInputStream(in));
        }
        this.attributeFactory = attributeFactory;
    }
    ClassFile getClassFile() {
        return this.classFile;
    }

    ConstantPool getConstantPool() {
        return this.classFile.getConstantPool();
    }

    public Attribute readAttribute() throws IOException {
        int attribute_name_index = this.readUnsignedShort();
        int attribute_length = this.readInt();
        byte[] info = new byte[attribute_length];
        this.readFully(info);
        DataInputStream inputStream = this.in;
        this.in = new DataInputStream(new ByteArrayInputStream(info));

        Attribute attribute;
        try {
            attribute = this.attributeFactory.createAttribute(this, attribute_name_index, info);
        } finally {
            this.in = inputStream;
        }

        return attribute;
    }

    @Override
    public void readFully(byte[] b) throws IOException {
        this.in.readFully(b);
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
        this.in.readFully(b,off,len);
    }

    @Override
    public int skipBytes(int n) throws IOException {
        return this.in.skipBytes(n);
    }

    @Override
    public boolean readBoolean() throws IOException {
        return this.in.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        return this.in.readByte();
    }

    @Override
    public int readUnsignedByte() throws IOException {
        return this.in.readUnsignedByte();
    }

    @Override
    public short readShort() throws IOException {
        return this.in.readShort();
    }

    @Override
    public int readUnsignedShort() throws IOException {
        return this.in.readUnsignedShort();
    }

    @Override
    public char readChar() throws IOException {
        return this.in.readChar();
    }

    @Override
    public int readInt() throws IOException {
        return this.in.readInt();
    }

    @Override
    public long readLong() throws IOException {
        return this.in.readLong();
    }

    @Override
    public float readFloat() throws IOException {
        return this.in.readFloat();
    }

    @Override
    public double readDouble() throws IOException {
        return this.in.readDouble();
    }

    @Override
    public String readLine() throws IOException {
        return this.in.readLine();
    }

    @Override
    public String readUTF() throws IOException {
        return this.in.readUTF();
    }

}
