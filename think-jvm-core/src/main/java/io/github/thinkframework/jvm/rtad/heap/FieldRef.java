package io.github.thinkframework.jvm.rtad.heap;

import io.github.thinkframework.jvm.classfile.constant.CONSTANT_Fieldref_info;
import io.github.thinkframework.jvm.exceptions.VMException;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class FieldRef extends MemberRef{
    public Field field;
    public FieldRef(){

    }
    public FieldRef(int tag,ConstantPool constantPool, CONSTANT_Fieldref_info clazz){
        super(tag,constantPool,clazz);

    }

    public Field resolvedField(){
        if(field == null){
            resolveFieldRef();
        }
        return field;
    }

    public void resolveFieldRef(){
        Clazz d = cp.getClazz();
        Clazz c = resolvedClass();
        this.clazz = c;
        this.field = lookupfield(c,name,descriptor);
        if(field == null){
            throw new VMException("java.lang.NoSuchFieldError");
        }
//        if(!field.is)
    }

    public Field lookupfield(Clazz clazz, String name, String descriptor){
        for(Field field : clazz.getFields()){
            if(field.name.equals(name) && field.getDescriptor().equals(descriptor)){// && field.type_index.equals(type_index)){
                return field;
            }
        }
        for(Clazz iface : clazz.getInterfaces()){
            Field field;
            if((field = lookupfield(iface,name,descriptor)) != null){
                return field;
            }
        }
        if(clazz.getSuperClazz() != null){
            Field field;
            if((field = lookupfield(clazz.getSuperClazz(),name,descriptor)) != null){
                return field;
            }
        }
        return null;
    }
}
