package io.github.thinkframework.jvm.rtad.heap;

import io.github.thinkframework.jvm.classfile.constant.CONSTANT_Methodref_info;
import io.github.thinkframework.jvm.exceptions.VMException;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class MethodRef extends MemberRef{
    private Method method;
    public MethodRef(){

    }
    public MethodRef(int tag,ConstantPool constantPool, CONSTANT_Methodref_info constant_class_info){
        super(tag,constantPool,constant_class_info);
    }

    public Method resolvedMethod(){
        if(method == null){
            resolveMethodRef();
        }
        return method;
    }

    public void resolveMethodRef(){
        Clazz d = cp.getClazz();
        Clazz c = resolvedClass();
        this.clazz = c;
        if(c.getAccessFlags().isInterface()){
            throw new VMException("java.lang.IncompatibleClassChangeError");
        }
        this.method = lookupMethod(clazz,name,descriptor);
        if(method == null){
            throw new VMException("java.lang.NoSouchMethodException");
        }
    }

    public Method lookupMethod(Clazz clazz, String name, String descriptor){
        Method method1 = getMethodInClass(clazz, name, descriptor);
        if (method1 != null) return method1;
        Method method2 = getMethodInInterfaces(clazz.getInterfaces(), name, descriptor);
        if (method2 != null) return method2;
        return null;
    }

    private Method getMethodInInterfaces(Clazz[] interfaces, String name, String descriptor) {
        for(Clazz iface : interfaces){
            for(Method method : iface.getMethods()){
                if(method.name.equals(name)){// && field.type_index.equals(type_index)){
                    return method;
                }
            }
            Method method = getMethodInInterfaces(clazz.getInterfaces(), name, descriptor);
            if(method != null){
                return method;
            }
        }
        return null;
    }

    private Method getMethodInClass(Clazz clazz, String name, String descriptor) {
        for(Method method : clazz.getMethods()){
            if(method.name.equals(name)){// && field.type_index.equals(type_index)){
                return method;
            }
        }
        if(clazz.getSuperClazz() != null){
            Method method;
            if((method = lookupMethod(clazz.getSuperClazz(),name,descriptor)) != null){
                return method;
            }
        }
        return null;
    }
}
