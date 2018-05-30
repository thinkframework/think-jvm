package org.think.jvm.classfile;

import org.think.jvm.classfile.attribute.*;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.Method
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassFileMethod extends CliassFileMember {

    public ClassFileMethod(ClassFileReader classFileReader) throws IOException {
        super(classFileReader);
    }

    public Code_attribute getCode_attribute(){
        for(Attribute attribute : attributes.attrs){
            if(attribute instanceof org.think.jvm.classfile.attribute.Code_attribute){
                return (Code_attribute)attribute;
            }
        }
        return null;
    }

    public Integer getMax_stack() {
        if(getCode_attribute() != null) {
            return getCode_attribute().getMax_stack();
        }else{
            return 0;
        }
    }

    public Integer getMax_locals() {
        if(getCode_attribute() != null) {
            return getCode_attribute().getMax_locals();
        }else{
            return 0;
        }
    }

    public byte[] getCode() {
        if(getCode_attribute() != null) {
            return getCode_attribute().getCode();
        }else{
            return new byte[1];
        }
    }

    public String getName(ConstantPool constantPool) {
        return constantPool.getUTF8Value(this.name_index);
    }
//    @Override
//    public String toString() {
//        CONSTANT_Utf8_info descriptor_utf_8 = (CONSTANT_Utf8_info) classFile.constant_pool.get(ByteUtils.u2toint(descriptor_index));
//        StringBuffer stringBuffer = new StringBuffer();
//
//        CONSTANT_Utf8_info name_utf_8 = (CONSTANT_Utf8_info) classFile.constant_pool.get(ByteUtils.u2toint(name_index));
//        stringBuffer.append(name_utf_8.toString());
////        if(attribute_info[0] instanceof ConstantValue){
////            ConstantValue constantValue =  (ConstantValue)attribute_info[0];
////            CONSTANT_Utf_8 constantValue_utf_8 = (CONSTANT_Utf_8) constant_pool[ByteUtils.u2toint(constantValue.constantvalue_index)];
////            stringBuffer.append(constantValue_utf_8.toString());
////        }
//        return  stringBuffer.toString();
//    }
}
