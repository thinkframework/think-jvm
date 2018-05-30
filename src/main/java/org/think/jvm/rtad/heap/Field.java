package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.ClassFileField;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Field extends ClassMember{
    public Integer constValueIndex;
    public Integer soltId;

    public Field(){

    }

    public Field(Clazz clazz, ClassFileField classFileField){
        super(clazz, classFileField);
        constValueIndex = classFileField.getContastValue();
    }

    public Boolean isStatic(){
        return accessFlags.isStatic();
    }

    public final boolean isFinal() {
       return accessFlags.isFinal();
    }

    public Boolean isLongOrDouble(){
        if("J".equals(descriptor) || "D".equals(descriptor)){
            return true;
        }else{
            return false;
        }
    }
}
