package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.Attribute;
import org.think.jvm.classfile.ClassFileMethod;
import org.think.jvm.classfile.attribute.Code_attribute;
import org.think.jvm.classfile.attribute.Exceptions_attribute;

public class ExceptionTable {
    ExceptionHandler[] exceptionHandlers;

    public ExceptionTable(Clazz clazz, ClassFileMethod classFileMethod){
        //异常表
        for(Attribute attribute : classFileMethod.attributes.attrs){
            if(attribute instanceof Code_attribute){
                Code_attribute code_attribute = (Code_attribute)attribute;
                Integer exception_table_length = code_attribute.getException_table_length();
                Code_attribute.Exception_data[] exception_datas = code_attribute.getException_table();
                exceptionHandlers = new ExceptionHandler[exception_table_length];
                for(int i=0;i<exception_table_length;i++){
                    Code_attribute.Exception_data exception_data = exception_datas[i];
                    exceptionHandlers[i] = new ExceptionHandler();
                    exceptionHandlers[i].setStartPc(exception_data.getStart_pc());
                    exceptionHandlers[i].setEndPc(exception_data.getEnd_pc());
                    exceptionHandlers[i].setHandlerPc(exception_data.getHandler_pc());
                    exceptionHandlers[i].setCatchType(getCacheType(clazz.getConstantPool(),exception_data.getCatch_type()));

                }
            }
        }
    }

    public ExceptionTable(ExceptionHandler[] exceptionHandlers){
        this.exceptionHandlers = exceptionHandlers;
    }

    public ExceptionHandler findExceptionHandler(Clazz clazz,Integer pc){
        for(ExceptionHandler exceptionHandler : exceptionHandlers){
            if(pc >= exceptionHandler.getStartPc() && pc < exceptionHandler.getEndPc()){
                if(exceptionHandler.getCatchType() == null){
                    return null;
                }
            }
            Clazz catchClass = exceptionHandler.getCatchType().resolvedClass();
            if(catchClass == clazz || catchClass.isSuperClassOf(clazz)){
                return exceptionHandler;
            }
        }
        return null;
    }
    public ExceptionHandler[] getExceptionHandlers() {
        return exceptionHandlers;
    }

    public void setExceptionHandlers(ExceptionHandler[] exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }

    public ClassRef getCacheType(ConstantPool constantPool,Integer index){
        if(index == 0){
            return null;
        }
        return (ClassRef)constantPool.getConstant(index);
    }
}
