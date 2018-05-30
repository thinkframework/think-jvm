package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.CliassFileMember;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassMember {
    protected AccessFlags accessFlags;
    protected String name;
    protected String descriptor;
    public Clazz clazz;

    public ClassMember(){

    }

    public ClassMember(Clazz clazz, CliassFileMember cliassFileMember){
        this.clazz = clazz;
        accessFlags = new AccessFlags(cliassFileMember.access_flags.getValue());
        name = cliassFileMember.getName();
        descriptor = cliassFileMember.getType_index();
    }

    public AccessFlags getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(AccessFlags accessFlags) {
        this.accessFlags = accessFlags;
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
