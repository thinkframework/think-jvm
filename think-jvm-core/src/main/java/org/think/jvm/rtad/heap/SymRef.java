package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.CPInfo;
import org.think.jvm.exceptions.VMException;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class SymRef extends Constant{
    protected String className;
    protected Clazz clazz;
    public SymRef(){

    }
    public SymRef(int tag,ConstantPool cp, CPInfo cpInfo){
        this.tag = tag;
        this.cp = cp;
    }

    public Clazz resolvedClass(){
        if(clazz == null){
            resolveClassRef();
        }
        return clazz;
    }

    public void resolveClassRef(){
        Clazz d = cp.getClazz();
        Clazz c = d.getClazzLoader().loadClass(className);
//        if(c.isAssignableTo(d)){
//            throw new VMException("java.lang.IllegalAccessError");
//        }
        this.clazz = c;
    }
}
