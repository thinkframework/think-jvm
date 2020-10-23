package io.github.thinkframework.jvm.classfile;


import java.io.IOException;

/**
 * @see org.apache.bcel.classfile.FieldOrMethod
 * @author lixiaobin
 * @since 2017/3/14.
 */
public class CliassFileMember {
    public ClassFileReader classFileReader;
    public AccessFlags access_flags;
    public int name_index;
    public int type_index;
    public Attributes attributes;

    public CliassFileMember(){

    }

    public CliassFileMember(ClassFileReader classFileReader) throws IOException {
        this.classFileReader = classFileReader;
        this.access_flags = new AccessFlags(classFileReader);
        this.name_index = classFileReader.readUnsignedShort();
        this.type_index = classFileReader.readUnsignedShort();
        this.attributes = new Attributes(classFileReader);
    }

    public String getName(){
        return classFileReader.getConstantPool().get(name_index).toString();
    }
    public String getType_index(){
        return classFileReader.getConstantPool().get(type_index).toString();
    }
}
