package org.think.jvm.classfile;

import org.think.jvm.classfile.attribute.*;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @see com.sun.tools.classfile.Attribute
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Attribute {
    public static final String AnnotationDefault = "AnnotationDefault";
    public static final String BootstrapMethods = "BootstrapMethods";
    public static final String CharacterRangeTable = "CharacterRangeTable";
    public static final String Code = "Code";
    public static final String ConstantValue = "ConstantValue";
    public static final String CompilationID = "CompilationID";
    public static final String Deprecated = "Deprecated";
    public static final String EnclosingMethod = "EnclosingMethod";
    public static final String Exceptions = "Exceptions";
    public static final String InnerClasses = "InnerClasses";
    public static final String LineNumberTable = "LineNumberTable";
    public static final String LocalVariableTable = "LocalVariableTable";
    public static final String LocalVariableTypeTable = "LocalVariableTypeTable";//unuse
    public static final String MethodParameters = "MethodParameters";
    public static final String RuntimeVisibleAnnotations = "RuntimeVisibleAnnotations";
    public static final String RuntimeInvisibleAnnotations = "RuntimeInvisibleAnnotations";
    public static final String RuntimeVisibleParameterAnnotations = "RuntimeVisibleParameterAnnotations";
    public static final String RuntimeInvisibleParameterAnnotations = "RuntimeInvisibleParameterAnnotations";
    public static final String RuntimeVisibleTypeAnnotations = "RuntimeVisibleTypeAnnotations";
    public static final String RuntimeInvisibleTypeAnnotations = "RuntimeInvisibleTypeAnnotations";
    public static final String Signature = "Signature";
    public static final String SourceDebugExtension = "SourceDebugExtension";
    public static final String SourceFile = "SourceFile";
    public static final String SourceID = "SourceID";
    public static final String StackMap = "StackMap";
    public static final String StackMapTable = "StackMapTable";
    public static final String Synthetic = "Synthetic";

    protected ClassFile classFile;

    private int attribute_name_index;
    private int attribute_length;

    public static Attribute read(ClassFileReader classFileReader) throws IOException {
        return classFileReader.readAttribute();
    }

    public Attribute(){

    }
    protected Attribute(int attribute_name_index, int attribute_length) {
        this.attribute_name_index = attribute_name_index;
        this.attribute_length = attribute_length;
    }

    public static class Factory {
        private Map<String, Class<? extends Attribute>> standardAttributes;

        public Factory() {
        }

        public Attribute createAttribute(ClassFileReader classFileReader, int attribute_name_index, byte[] info) throws IOException {
            if(this.standardAttributes == null) {
                this.init();
            }

            ConstantPool constantPool = classFileReader.getConstantPool();

                String name = constantPool.getUTF8Value(attribute_name_index);
                Class clazz = (Class)this.standardAttributes.get(name);
                if(clazz != null) {
                    try {
                        Class[] parameterTypes = new Class[]{ClassFileReader.class, Integer.TYPE, Integer.TYPE};
                        Constructor constructor = clazz.getDeclaredConstructor(parameterTypes);
                        return (Attribute)constructor.newInstance(new Object[]{classFileReader, Integer.valueOf(attribute_name_index), Integer.valueOf(info.length)});
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return null;
                } else {
                    throw new IOException("unknown attribute"+name);
                }
        }

        protected void init() {
            this.standardAttributes = new HashMap();
            this.standardAttributes.put("AnnotationDefault", AnnotationDefault_attribute.class);
            this.standardAttributes.put("BootstrapMethods", BootstrapMethods_attribute.class);
            this.standardAttributes.put("CharacterRangeTable", CharacterRangeTable_attribute.class);
            this.standardAttributes.put("Code", Code_attribute.class);
            this.standardAttributes.put("CompilationID", CompilationID_attribute.class);
            this.standardAttributes.put("ConstantValue", ConstantValue_attribute.class);
            this.standardAttributes.put("Deprecated", Deprecated_attribute.class);
            this.standardAttributes.put("EnclosingMethod", EnclosingMethod_attribute.class);
            this.standardAttributes.put("Exceptions", Exceptions_attribute.class);
            this.standardAttributes.put("InnerClasses", InnerClasses_attribute.class);
            this.standardAttributes.put("LineNumberTable", LineNumberTable_attribute.class);
            this.standardAttributes.put("LocalVariableTable", LocalVariableTable_attribute.class);
            this.standardAttributes.put("LocalVariableTypeTable", LocalVariableTypeTable_attribute.class);
            this.standardAttributes.put("MethodParameters", MethodParameters_attribute.class);
            this.standardAttributes.put("RuntimeInvisibleAnnotations", RuntimeInvisibleAnnotations_attribute.class);
            this.standardAttributes.put("RuntimeInvisibleParameterAnnotations", RuntimeInvisibleParameterAnnotations_attribute.class);
            this.standardAttributes.put("RuntimeVisibleAnnotations", RuntimeVisibleAnnotations_attribute.class);
            this.standardAttributes.put("RuntimeVisibleParameterAnnotations", RuntimeVisibleParameterAnnotations_attribute.class);
            this.standardAttributes.put("RuntimeVisibleTypeAnnotations", RuntimeVisibleTypeAnnotations_attribute.class);
            this.standardAttributes.put("RuntimeInvisibleTypeAnnotations", RuntimeInvisibleTypeAnnotations_attribute.class);
            this.standardAttributes.put("Signature", Signature_attribute.class);
            this.standardAttributes.put("SourceDebugExtension", SourceDebugExtension_attribute.class);
            this.standardAttributes.put("SourceFile", SourceFile_attribute.class);
            this.standardAttributes.put("SourceID", SourceID_attribute.class);
            this.standardAttributes.put("StackMap", StackMap_attribute.class);
            this.standardAttributes.put("StackMapTable", StackMapTable_attribute.class);
            this.standardAttributes.put("Synthetic", Synthetic_attribute.class);
        }
    }
}
