package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.ClassFileMethod;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Method extends ClassMember{
    public Integer maxStack;
    public Integer maxLocals;
    public byte[] code;
    public Integer argSlotcount;
    public Method(){

    }

    public Method(Clazz clazz, ClassFileMethod classFileMethod){
        super(clazz, classFileMethod);
        maxStack = classFileMethod.getMax_stack();
        maxLocals = classFileMethod.getMax_locals();
        code = classFileMethod.getCode();
        calcArgSlotCount();
        if(accessFlags.isNative()){
            injectCodeAttribute();
        }
    }

    public void injectCodeAttribute(){
        maxStack = 4;
        maxLocals = argSlotcount;
        switch (descriptor){
            case "V":
                code = new byte[]{(byte) 0xfe,(byte) 0xb1};
                break;
            case "D":
                code = new byte[]{(byte) 0xfe,(byte) 0xaf};
                break;
            case "F":
                code = new byte[]{(byte) 0xfe,(byte) 0xae};
                break;
            case "J":
                code = new byte[]{(byte) 0xfe,(byte) 0xfe};
                break;
            case "H":
                code = new byte[]{(byte) 0xfe,(byte) 0xb0};
                break;
            default:
                code = new byte[]{(byte) 0xfe,(byte) 0xac};
                break;
        }
    }

    public void calcArgSlotCount(){
        argSlotcount = 0;
        String s = "";
        for(int i=0;i<descriptor.length();i++){
            if('(' == descriptor.charAt(i)){
                continue;
            }
            s+=descriptor.charAt(i);
            if(')' == descriptor.charAt(i)){
                break;
            }
        }
        if(!accessFlags.isStatic()){//this
            argSlotcount++;
        }
    }

    public Integer getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(Integer maxStack) {
        this.maxStack = maxStack;
    }

    public Integer getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(Integer maxLocals) {
        this.maxLocals = maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public Integer getArgSlotcount() {
        return argSlotcount;
    }

    public void setArgSlotcount(Integer argSlotcount) {
        this.argSlotcount = argSlotcount;
    }
}
