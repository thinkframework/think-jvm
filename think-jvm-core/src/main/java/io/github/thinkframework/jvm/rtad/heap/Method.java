package io.github.thinkframework.jvm.rtad.heap;

import io.github.thinkframework.jvm.classfile.ClassFileMethod;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Method extends ClassMember{
    public Integer maxStack;
    public Integer maxLocals;
    public byte[] code;
    public Integer argSlotcount;

    private ExceptionTable exceptionTable;

    public Method(){

    }

    public Method(Clazz clazz, ClassFileMethod classFileMethod){
        super(clazz, classFileMethod);
        maxStack = classFileMethod.getMax_stack();
        maxLocals = classFileMethod.getMax_locals();
        code = classFileMethod.getCode();

        MethodDescriptor methodDescriptor = new MethodDescriptor(descriptor);
        calcArgSlotCount(methodDescriptor);
        if(accessFlags.isNative()){
            injectCodeAttribute(methodDescriptor.getReturnType());
        }

        this.exceptionTable = new ExceptionTable(clazz,classFileMethod);
    }

    public void injectCodeAttribute(String returnType){
        maxStack = 4;
        maxLocals = argSlotcount;
        switch (returnType.substring(0,1)){
            case "V":
                code = new byte[]{(byte) 0xfe,(byte) 0xb1};//return
                break;
            case "D":
                code = new byte[]{(byte) 0xfe,(byte) 0xaf};//dreturn
                break;
            case "F":
                code = new byte[]{(byte) 0xfe,(byte) 0xae};//freturn
                break;
            case "J":
                code = new byte[]{(byte) 0xfe,(byte) 0xad};//lreturn
                break;
            case "L":
            case "[":
                code = new byte[]{(byte) 0xfe,(byte) 0xb0};//areturn
                break;
            default:
                code = new byte[]{(byte) 0xfe,(byte) 0xac};//ireturn
                break;
        }
    }

    public void calcArgSlotCount(MethodDescriptor methodDescriptor){
        argSlotcount = 0;
        String[] parameterTypes = methodDescriptor.getParameterTypes();
        if(parameterTypes != null && parameterTypes.length > 0) {
            for (String parameterType : parameterTypes) {
                argSlotcount++;
                if ("J".equals(parameterType) || "D".equals(parameterType)) {
                    argSlotcount++;
                }

            }
        }
        if(!accessFlags.isStatic()){//this
            argSlotcount++;
        }
    }

    public Integer findExceptionHandler(Clazz clazz,Integer pc){
        ExceptionHandler handler = exceptionTable.findExceptionHandler(clazz,pc);
        if(handler != null){
            return handler.getHandlerPc();
        }
        return -1;
    }

    public Integer getLineNumber(Integer pc){
//        for(int i=0;l)
        return -1;
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

