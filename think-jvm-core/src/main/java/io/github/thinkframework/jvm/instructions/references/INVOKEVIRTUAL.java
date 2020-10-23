package io.github.thinkframework.jvm.instructions.references;

import io.github.thinkframework.jvm.Visitor;
import io.github.thinkframework.jvm.exceptions.VMException;
import io.github.thinkframework.jvm.instructions.base.Index16Instruction;
import io.github.thinkframework.jvm.rtad.Frame;
import io.github.thinkframework.jvm.rtad.OperandStack;
import io.github.thinkframework.jvm.rtad.heap.Clazz;
import io.github.thinkframework.jvm.rtad.heap.ConstantPool;
import io.github.thinkframework.jvm.rtad.heap.Method;
import io.github.thinkframework.jvm.rtad.heap.MethodRef;

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
        if("println".equals(method.getName())){
            OperandStack operandStack = visitor.getFrame().getStack();
            log.info("{}",operandStack.popSolt());
            return;
        }
        Object object = frame.getStack().getRefFromTop(method.argSlotcount-1);
        if(object == null){
            throw new VMException("java.lang.NullPointException");
        }
        Method methodToBeInvoked = method;
//        LookupMethodInClass(clazz.superClazz,method.getName(),method.getDescriptor());
        if("println".equals(method.getName())){
            OperandStack operandStack = visitor.getFrame().getStack();
            System.out.println(operandStack.popSolt());
        }else{
            invokeMethod(frame,methodToBeInvoked);
        }
    }
}
