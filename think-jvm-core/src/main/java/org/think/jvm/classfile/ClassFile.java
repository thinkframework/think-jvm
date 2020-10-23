package org.think.jvm.classfile;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 ClassFile {
 u4             magic;
 u2             minorVersion;
 u2             majorVersion;
 u2             constant_pool_count;
 cp_info        constant_pool[constant_pool_count-1];
 u2             value;
 u2             thisClass;
 u2             superClass;
 u2             interfaces_count;
 u2             interfaces[interfaces_count];
 u2             fields_count;
 field_info     fields[fields_count];
 u2             methods_count;
 method_info    methods[methods_count];
 u2             attributes_count;
 attribute_info attributes[attributes_count];
 }
 * @see com.sun.tools.classfile.ClassFile,org.apache.bcel.classfile
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassFile {
    private int magic;
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private AccessFlags accessFlags;
    private int thisClass;
    private int superClass;
    private int[] interfaces;
    private ClassFileField[] classFileFields;
    private ClassFileMethod[] classFileMethods;
    private Attributes attributes;
    private ClassFile(){
    }

    public ClassFile(InputStream inputStream) throws IOException{
        ClassFileReader classFileReader = new ClassFileReader(this,inputStream,new Attribute.Factory());
        this.magic = classFileReader.readInt();
        this.minorVersion = classFileReader.readUnsignedShort();
        this.majorVersion = classFileReader.readUnsignedShort();
        this.constantPool = new ConstantPool(classFileReader);
        this.accessFlags = new AccessFlags(classFileReader);
        this.thisClass = classFileReader.readUnsignedShort();
        this.superClass = classFileReader.readUnsignedShort();
        int interfaces_count = classFileReader.readUnsignedShort();
        this.interfaces = new int[interfaces_count];

        for(int i = 0; i < interfaces_count; i++) {
            this.interfaces[i] = classFileReader.readUnsignedShort();
        }

        int fields_count = classFileReader.readUnsignedShort();
        this.classFileFields = new ClassFileField[fields_count];

        for(int i = 0; i < fields_count; i++) {
            this.classFileFields[i] = new ClassFileField(classFileReader);
        }

        int methods_count = classFileReader.readUnsignedShort();
        this.classFileMethods = new ClassFileMethod[methods_count];

        for(int i = 0; i < methods_count; ++i) {
            this.classFileMethods[i] = new ClassFileMethod(classFileReader);
        }

        this.attributes = new Attributes(classFileReader);
    }


    @Override
    public String toString() {
        return constantPool.get(thisClass).toString();
    }

    public String getName(){
        return constantPool.get(thisClass).toString();
    }


    public String getSuperClassName(){
        CPInfo cpInfo = constantPool.get(superClass);//java/lang/Object
        return cpInfo == null ? null : cpInfo.toString();
    }


    public String[] getInterfaceNames(){
        String[] interfaceNames = new String[interfaces.length];
                for(int i=0;i<interfaces.length;i++){
                    interfaceNames[i] = constantPool.get(interfaces[i]).toString();
                }
        return interfaceNames;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public AccessFlags getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(AccessFlags accessFlags) {
        this.accessFlags = accessFlags;
    }

    public int getThisClass() {
        return thisClass;
    }

    public void setThisClass(int thisClass) {
        this.thisClass = thisClass;
    }

    public int getSuperClass() {
        return superClass;
    }

    public void setSuperClass(int superClass) {
        this.superClass = superClass;
    }

    public int[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(int[] interfaces) {
        this.interfaces = interfaces;
    }

    public ClassFileField[] getClassFileFields() {
        return classFileFields;
    }

    public void setClassFileFields(ClassFileField[] classFileFields) {
        this.classFileFields = classFileFields;
    }

    public ClassFileMethod[] getClassFileMethods() {
        return classFileMethods;
    }

    public void setClassFileMethods(ClassFileMethod[] classFileMethods) {
        this.classFileMethods = classFileMethods;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
