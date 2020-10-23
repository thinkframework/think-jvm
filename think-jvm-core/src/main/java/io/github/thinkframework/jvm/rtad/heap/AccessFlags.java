package io.github.thinkframework.jvm.rtad.heap;


import io.github.thinkframework.jvm.classfile.ClassFileReader;

import java.io.IOException;

/**
 * @see com.sun.tools.classfile.AccessFlags,org.apache.bcel.classfile.AccessFlags
 * @author lixiaobin
 * @author lixiaobin
 * @since 2017/3/24
 */
public class AccessFlags {
    public static final int ACC_PUBLIC = 1;
    public static final int ACC_PRIVATE = 2;
    public static final int ACC_PROTECTED = 4;
    public static final int ACC_STATIC = 8;
    public static final int ACC_FINAL = 16;
    public static final int ACC_SUPER = 32;
    public static final int ACC_SYNCHRONIZED = 32;
    public static final int ACC_VOLATILE = 64;
    public static final int ACC_BRIDGE = 64;
    public static final int ACC_TRANSIENT = 128;
    public static final int ACC_VARARGS = 128;
    public static final int ACC_NATIVE = 256;
    public static final int ACC_INTERFACE = 512;
    public static final int ACC_ABSTRACT = 1024;
    public static final int ACC_STRICT = 2048;
    public static final int ACC_SYNTHETIC = 4096;
    public static final int ACC_ANNOTATION = 8192;
    public static final int ACC_ENUM = 16384;
    public static final int ACC_MANDATED = 32768;
    private int value;

    public AccessFlags(ClassFileReader classFileReader) throws IOException{
        this(classFileReader.readUnsignedShort());
    }

    public AccessFlags(int var1) {
        this.value = var1;
    }

    public final void isPublic(final boolean flag) {
        setFlag(ACC_PUBLIC, flag);
    }

    public final boolean isPublic() {
        return (value & ACC_PUBLIC) != 0;
    }

    public final void isPrivate(final boolean flag) {
        setFlag(ACC_PRIVATE, flag);
    }

    public final boolean isPrivate() {
        return (value & ACC_PRIVATE) != 0;
    }

    public final void isProtected(final boolean flag) {
        setFlag(ACC_PROTECTED, flag);
    }

    public final boolean isProtected() {
        return (value & ACC_PROTECTED) != 0;
    }

    public final void isStatic(final boolean flag) {
        setFlag(ACC_STATIC, flag);
    }

    public final boolean isStatic() {
        return (value & ACC_STATIC) != 0;
    }

    public final void isFinal(final boolean flag) {
        setFlag(ACC_FINAL, flag);
    }

    public final boolean isFinal() {
        return (value & ACC_FINAL) != 0;
    }


    public final void isSuper(final boolean flag) {
        setFlag(ACC_SUPER, flag);
    }

    public final boolean isSuper() {
        return (value & ACC_SUPER) != 0;
    }

    public final void isSynchronized(final boolean flag) {
        setFlag(ACC_SYNCHRONIZED, flag);
    }

    public final boolean isSynchronized() {
        return (value & ACC_SYNCHRONIZED) != 0;
    }

    public final void isVolatile(final boolean flag) {
        setFlag(ACC_VOLATILE, flag);
    }

    public final boolean isVolatile() {
        return (value & ACC_VOLATILE) != 0;
    }

    public final void isTransient(final boolean flag) {
        setFlag(ACC_TRANSIENT, flag);
    }

    public final boolean isTransient() {
        return (value & ACC_TRANSIENT) != 0;
    }

    public final void isNative(final boolean flag) {
        setFlag(ACC_NATIVE, flag);
    }

    public final boolean isNative() {
        return (value & ACC_NATIVE) != 0;
    }

    public final void isInterface(final boolean flag) {
        setFlag(ACC_INTERFACE, flag);
    }

    public final boolean isInterface() {
        return (value & ACC_INTERFACE) != 0;
    }

    public final void isAbstract(final boolean flag) {
        setFlag(ACC_ABSTRACT, flag);
    }

    public final boolean isAbstract() {
        return (value & ACC_ABSTRACT) != 0;
    }

    public final void isStrictfp(final boolean flag) {
        setFlag(ACC_STRICT, flag);
    }

    public final boolean isStrictfp() {
        return (value & ACC_STRICT) != 0;
    }

    public final void isSynthetic(final boolean flag) {
        setFlag(ACC_SYNTHETIC, flag);
    }

    public final boolean isSynthetic() {
        return (value & ACC_SYNTHETIC) != 0;
    }

    public final void isAnnotation(final boolean flag) {
        setFlag(ACC_ANNOTATION, flag);
    }

    public final boolean isAnnotation() {
        return (value & ACC_ANNOTATION) != 0;
    }

    public final void isEnum(final boolean flag) {
        setFlag(ACC_ENUM, flag);
    }

    public final boolean isEnum() {
        return (value & ACC_ENUM) != 0;
    }

    public final void isVarArgs(final boolean flag) {
        setFlag(ACC_VARARGS, flag);
    }

    public final boolean isVarArgs() {
        return (value & ACC_VARARGS) != 0;
    }
    private void setFlag(final int flag, final boolean set){

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
