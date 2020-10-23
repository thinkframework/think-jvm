package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.constant.CPRefInfo;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class MemberRef extends SymRef {
    protected String name;
    protected String descriptor;
    public MemberRef(){

    }
    public MemberRef(int tag,ConstantPool constantPool, CPRefInfo cpRefInfo){
        super(tag,constantPool,cpRefInfo);
        className = cpRefInfo.getClassName();
        name = cpRefInfo.getName();
        descriptor = cpRefInfo.getType();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}
