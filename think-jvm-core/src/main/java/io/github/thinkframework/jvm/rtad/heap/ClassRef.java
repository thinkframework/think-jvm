package io.github.thinkframework.jvm.rtad.heap;

import io.github.thinkframework.jvm.classfile.constant.CONSTANT_Class_info;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassRef extends SymRef {
    public ClassRef(){

    }
    public ClassRef(int tag,ConstantPool constantPool, CONSTANT_Class_info constant_class_info){
        super(tag,constantPool,constant_class_info);
        className = constant_class_info.toString();
    }
}
