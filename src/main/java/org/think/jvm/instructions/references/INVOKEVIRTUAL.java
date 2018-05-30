package org.think.jvm.instructions.references;

import org.think.jvm.Visitor;
import org.think.jvm.exceptions.VMException;
import org.think.jvm.instructions.base.Index16Instruction;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.OperandStack;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ConstantPool;
import org.think.jvm.rtad.heap.Method;
import org.think.jvm.rtad.heap.MethodRef;

/*
*调用实例方法
*@author lixiaobin
*/
public class INVOKEVIRTUAL extends Index16Instruction {

    @Override
    public void execute(Visitor visitor) {
        super.execute(visitor);
        Frame frame = visitor.getFrame();
        ConstantPool constantPool = frame.getMethod().getClazz().getConstantPool();
        MethodRef methodRef = (MethodRef)constantPool.getConstant(index);
        Clazz clazz = methodRef.resolvedClass();
        Method method = methodRef.resolvedMethod();
        Object object = frame.getStack().getRefFromTop(method.argSlotcount-1);
        if(object == null){
            throw new VMException("java.lang.NullPointException");
        }
        Method methodToBeInvoked = method;
//        LookupMethodInClass(clazz.superClazz,method.getName(),method.getDescriptor());
        if("println".equals(methodRef.getName())){
            OperandStack operandStack = visitor.getFrame().getStack();
            log.info(operandStack.popSolt());
        }else{
            invokeMethod(frame,methodToBeInvoked);
        }
    }
}
