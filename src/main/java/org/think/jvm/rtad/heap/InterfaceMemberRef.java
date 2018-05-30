package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.constant.CONSTANT_InterfaceMethodref_info;
import org.think.jvm.exceptions.VMException;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class InterfaceMemberRef extends MemberRef {
    private Method method;
    public InterfaceMemberRef(){

    }
    public InterfaceMemberRef(int tag,ConstantPool constantPool,CONSTANT_InterfaceMethodref_info constant_class_info){
        super(tag,constantPool,constant_class_info);
    }


    public Method resolvedInterfaceMethod(){
        if(method == null){
            resolveInterfaceMethodRef();
        }
        return method;
    }

    public void resolveInterfaceMethodRef(){
        Clazz d = cp.getClazz();
        Clazz c = resolvedClass();
        this.clazz = c;
//        if(c.getAccessFlags().isInterface()){
//            throw new VMException("java.lang.IncompatibleClassChangeError");
//        }
        this.method = lookupInterfaceMethod(clazz,name,descriptor);
        if(method == null){
            throw new VMException("java.lang.NoSouchMethodException");
        }
    }


    public Method lookupInterfaceMethod(Clazz clazz, String name, String descriptor){
        for(Method method : clazz.getMethods()){
            if(method.name.equals(name)){// && field.type_index.equals(type_index)){
                return method;
            }
        }
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
}
