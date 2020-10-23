package io.github.thinkframework.jvm.classfile;

import io.github.thinkframework.jvm.classfile.constant.*;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.ConstantPool
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ConstantPool {
    private CPInfo[] pool;

    public CPInfo get(int i) {
        return pool[i];
    }

    public Integer getLength(){
        return pool.length;
    }

    public CPInfo[] getPool() {
        return pool;
    }

    public void setPool(CPInfo[] pool) {
        this.pool = pool;
    }

    public ConstantPool(ClassFileReader classFileReader) throws IOException {
        int pool_count = classFileReader.readUnsignedShort();
        this.pool = new CPInfo[pool_count];

        for (int i = 1; i < pool_count; i++) {
            int tag = classFileReader.readUnsignedByte();
            switch (tag) {
                case CPInfo.CONSTANT_Utf8:
                    this.pool[i] = new CONSTANT_Utf8_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_Integer:
                    this.pool[i] = new CONSTANT_Integer_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_Float:
                    this.pool[i] = new CONSTANT_Float_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_Long:
                    this.pool[i++] = new CONSTANT_Long_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_Double:
                    this.pool[i++] = new CONSTANT_Double_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_Class:
                    this.pool[i] = new CONSTANT_Class_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_String:
                    this.pool[i] = new CONSTANT_String_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_Fieldref:
                    this.pool[i] = new CONSTANT_Fieldref_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_Methodref:
                    this.pool[i] = new CONSTANT_Methodref_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_InterfaceMethodref:
                    this.pool[i] = new CONSTANT_InterfaceMethodref_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_NameAndType:
                    this.pool[i] = new CONSTANT_NameAndType_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_MethodHandle:
                    this.pool[i] = new CONSTANT_MethodHandle_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_MethodType:
                    this.pool[i] = new CONSTANT_MethodType_info(this, classFileReader);
                    break;
                case CPInfo.CONSTANT_InvokeDynamic:
                    this.pool[i] = new CONSTANT_InvokeDynamic_info(this, classFileReader);
                    break;
                case 2:
                case 13:
                case 14:
                case 17:
                default:
                    throw new IOException("无法解析的常量:" + tag);
            }
        }
    }

    public String getUTF8Value(int var1) {
        return this.get(var1).toString();
    }


}
