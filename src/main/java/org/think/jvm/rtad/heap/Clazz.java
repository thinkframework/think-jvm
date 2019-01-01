package org.think.jvm.rtad.heap;

import org.think.jvm.classfile.Attribute;
import org.think.jvm.classfile.CPInfo;
import org.think.jvm.classfile.ClassFile;
import org.think.jvm.classfile.attribute.SourceFile_attribute;
import org.think.jvm.classfile.constant.*;
import org.think.jvm.exceptions.VMException;
import org.think.jvm.rtad.Frame;
import sun.jvm.hotspot.runtime.VM;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Clazz {
    private AccessFlags accessFlags;
    private String name;
    private String supertClassName;
    private String[] interfaceNames;
    private ConstantPool constantPool;
    private Field[] fields;
    private Method[] methods;
    private ClazzLoader clazzLoader;
    private Clazz superClazz;
    private Clazz[] interfaces;
    private Integer instanceSlotCount;
    private Integer staticSoltcount;
    private Solts staticVars;
    private Boolean initStared =false;
    private ClassObject clazzObject;

    private String sourceFile;

    Clazz(){

    }


    public Clazz(AccessFlags accessFlags, String name, ClazzLoader clazzLoader, Clazz superClazz, Clazz[] interfaces, Boolean initStared){
        this.accessFlags = accessFlags;
        this.name = name;
        this.clazzLoader = clazzLoader;
        if(superClazz != null) {
            this.superClazz = superClazz;
            this.supertClassName = superClazz.name;
        }
        if(interfaces != null) {
            this.interfaces = interfaces;
            String[] interfaceNames = new String[interfaces.length];
            for (int i = 0; i < interfaces.length; i++) {
                interfaceNames[i] = interfaces[i].name;
            }
            this.interfaceNames = interfaceNames;
        }
        this.initStared = initStared;
    }

    public Clazz(ClassFile classFile){
        accessFlags = new AccessFlags(classFile.getAccessFlags().getValue());
        name = classFile.getName();
        supertClassName = classFile.getSuperClassName();
        interfaceNames = classFile.getInterfaceNames();
        constantPool = newConstantPool(classFile);
        fields = newFields(classFile);
        methods = newMethods(classFile);

//        sourceFile = getSourceFile();
    }

    public ConstantPool newConstantPool(ClassFile classFile) throws VMException{
        int length = classFile.getConstantPool().getLength();
        ConstantPool constantPool = new ConstantPool(this,length);
        Constant[] constants = constantPool.getConstants();
        for (int i = 1; i < length; i++) {//从1开始
           CPInfo cpInfo = classFile.getConstantPool().get(i);
           int tag = classFile.getConstantPool().get(i).getTag();
            switch (tag) {
                case CPInfo.CONSTANT_Utf8:
                    constantPool.setConstant(i,new Constant(tag,cpInfo.getConstantValue()));
                    break;
                case CPInfo.CONSTANT_Integer:
                    constantPool.setConstant(i,new Constant(tag,new Integer(cpInfo.getConstantValue().toString())));
                    break;
                case CPInfo.CONSTANT_Float:
                    constantPool.setConstant(i,new Constant(tag,new Float(cpInfo.getConstantValue().toString())));
                    break;
                case CPInfo.CONSTANT_Long:
                    constantPool.setConstant(i++,new Constant(tag,new Long(cpInfo.getConstantValue().toString())));
                    break;
                case CPInfo.CONSTANT_Double:
                    constantPool.setConstant(i++,new Constant(tag,new Double(cpInfo.getConstantValue().toString())));
                    break;
                case CPInfo.CONSTANT_Class:
                    constantPool.setConstant(i,new ClassRef(tag,constantPool, (CONSTANT_Class_info) cpInfo));
                    break;
                case CPInfo.CONSTANT_String:
                    constantPool.setConstant(i,new Constant(tag,cpInfo.getConstantValue()));
                    break;
                case CPInfo.CONSTANT_Fieldref:
                    constantPool.setConstant(i,new FieldRef(tag,constantPool, (CONSTANT_Fieldref_info) cpInfo));
                    break;
                case CPInfo.CONSTANT_Methodref:
                    constantPool.setConstant(i,new MethodRef(tag,constantPool, (CONSTANT_Methodref_info) cpInfo));
                    break;
                case CPInfo.CONSTANT_InterfaceMethodref:
                    constantPool.setConstant(i,new InterfaceMemberRef(tag,constantPool, (CONSTANT_InterfaceMethodref_info) cpInfo));
                    break;
                case CPInfo.CONSTANT_NameAndType:
                    constantPool.setConstant(i,new Constant(tag,cpInfo.getConstantValue()));
                    break;
                case CPInfo.CONSTANT_MethodHandle:
                    constantPool.setConstant(i,new Constant(tag,cpInfo.getConstantValue()));
                    break;
                case CPInfo.CONSTANT_MethodType:
                    constantPool.setConstant(i,new Constant(tag,cpInfo.getConstantValue()));
                    break;
                case CPInfo.CONSTANT_InvokeDynamic:
                    constantPool.setConstant(i,new Constant(tag,cpInfo.getConstantValue()));
                    break;
                default:
                    throw new VMException("无法解析的常量"+tag);
            }
        }
        return constantPool;
    }

    private Field[] newFields(ClassFile classFile){
        Field[] fields = new Field[classFile.getClassFileFields().length];
        for(int i = 0; i<classFile.getClassFileFields().length; i++){
            fields[i] = new Field(this,classFile.getClassFileFields()[i]);
        }
        return fields;
    }

    private Method[] newMethods(ClassFile classFile){
        Method[] methods = new Method[classFile.getClassFileMethods().length];
        for(int i = 0; i<classFile.getClassFileMethods().length; i++){
            methods[i] = new Method(this,classFile.getClassFileMethods()[i]);
        }
        return methods;
    }

    public ClazzLoader getClazzLoader() {
        return clazzLoader;
    }

    public void setClazzLoader(ClazzLoader clazzLoader) {
        this.clazzLoader = clazzLoader;
    }

    public Method getMainMethod(){
        for(Method method : methods){
            if("main".equals(method.getName())){
                return method;
            }
        }
        return null;
    }

    public ClassObject newObject(){
        ClassObject object = new ClassObject(this,instanceSlotCount);
        return object;
    }

    public ArrayObject newArray(int count){
        switch (name){
            case "[Z":
                return new ArrayObject(new Boolean[count]);
            case "[C":
                return new ArrayObject(new Character[count]);
            case "[F":
                return new ArrayObject(new Float[count]);
            case "[D":
                return new ArrayObject(new Double[count]);
            case "[B":
                return new ArrayObject(new Byte[count]);
            case "[S":
                return new ArrayObject(new Short[count]);
            case "[I":
                return new ArrayObject(new Integer[count]);
            case "[J":
                return new ArrayObject(new Long[count]);
            default:
                return new ArrayObject(new Object[count]);
        }
    }

    public Clazz ArrayClass(){
        String arrayClassName = "["+getArrayClassName();
        return clazzLoader.loadClass(arrayClassName);
    }



    private String getArrayClassName(){
        if(name.charAt(0) == '['){
            return name;
        }
        switch (name){
            case "void":
                return "V";
            case "boolean":
                return "Z";
            case "byte":
                return "B";
            case "shot":
                return "S";
            case "int":
                return "I";
            case "long":
                return "J";
            case "char":
                return "C";
            case "float":
                return "F";
            case "double":
                return "D";
        }
        return "L"+name+";";
    }


    public Clazz ComponentClass(){
        String componentClassName = getComponentClassName();
        return clazzLoader.loadClass(componentClassName);
    }

    private String getComponentClassName(){
        return toClassName(name.substring(1));
    }

    public String toClassName(String componentClassName) {
        if(name.charAt(0) == '['){
            return  componentClassName;
        }
        if(name.charAt(0) == 'L'){
            return  componentClassName.substring(1,componentClassName.length()-1);
        }
        switch (componentClassName){
            case "void":
                return "V";
            case "boolean":
                return "Z";
            case "byte":
                return "B";
            case "shot":
                return "S";
            case "int":
                return "I";
            case "long":
                return "J";
            case "char":
                return "C";
            case "float":
                return "F";
            case "double":
                return "D";
        }
        throw new VMException("");
    }

    public Boolean isAssignableFrom(Clazz clazz){
        if(this == clazz){
            return true;
        }
        if(!this.isArray()) {
            if (!accessFlags.isInterface()) {
                return isSubClassOf(clazz);
            } else {
                return isImplements(clazz);
            }
        }else{
            if(!clazz.isArray()){

            }else{
                return this.ComponentClass() == clazz.ComponentClass() || clazz.ComponentClass().isAssignableFrom(this.ComponentClass());
            }
        }
        //TODO
        return false;
    }

    public Boolean isArray(){
        return name.charAt(0) == '[';
    }

    public Boolean isSuper(){
        return accessFlags.isSuper();
    }

    public Boolean isSuperClassOf(Clazz clazz){
        for(Clazz aclazz = clazz.superClazz; aclazz != null; aclazz = aclazz.superClazz){
            if(this == aclazz){
                return true;
            }
        }
        return false;
    }

    public Boolean isSubClassOf(Clazz clazz){
        return true;
    }


    public Boolean isImplements(Clazz clazz){
        return true;
    }

    public Boolean isAssignableTo(Clazz clazz){
        return this.accessFlags.isPublic() || this.getPackageName().equals(clazz.getPackageName());
    }

    public String getPackageName(){
        return name.substring(0,name.lastIndexOf("/"));
    }

    public Boolean getInitStared() {
        return initStared;
    }

    public void setInitStared(Boolean initStared) {
        this.initStared = initStared;
    }

    public void init(org.think.jvm.rtad.Thread thread,Clazz clazz){
        clazz.setInitStared(true);
        scheduleClass(thread,clazz);
        initSuperClass(thread,clazz);
    }

//    private Method getInitMethod(){
//        for(Method method : methods){
//            if("<clinit>".equals(method.getName())){
//                return method;
//            }
//        }
//        return null;
//    }


    private Method getClinitMethod(){
        Clazz aclazz = this;
        for(Method[] amethods =aclazz.methods; aclazz != null; aclazz = aclazz.superClazz){
            for(Method method : amethods){
                if("<clinit>".equals(method.getName())){
                    return method;
                }
            }
        }
        return null;
    }


    public void scheduleClass(org.think.jvm.rtad.Thread thread,Clazz clazz){
        Method method = clazz.getClinitMethod();
        if(method != null){
            Frame frame = thread.newFrame(method);
            thread.pushFrame(frame);
        }
    }

    public void initSuperClass(org.think.jvm.rtad.Thread thread,Clazz clazz){
        if (clazz.superClazz != null && !clazz.superClazz.getInitStared()){
            init(thread,clazz.superClazz);
        }
    }

    public void setInterface(Integer index,Clazz clazz){
        interfaces[index] = clazz;
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

    public String getSupertClassName() {
        return supertClassName;
    }

    public void setSupertClassName(String supertClassName) {
        this.supertClassName = supertClassName;
    }

    public String[] getInterfaceNames() {
        return interfaceNames;
    }

    public void setInterfaceNames(String[] interfaceNames) {
        this.interfaceNames = interfaceNames;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public Clazz getSuperClazz() {
        return superClazz;
    }

    public void setSuperClazz(Clazz superClazz) {
        this.superClazz = superClazz;
    }

    public Clazz[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Clazz[] interfaces) {
        this.interfaces = interfaces;
    }

    public Integer getInstanceSlotCount() {
        return instanceSlotCount;
    }

    public void setInstanceSlotCount(Integer instanceSlotCount) {
        this.instanceSlotCount = instanceSlotCount;
    }

    public Integer getStaticSoltcount() {
        return staticSoltcount;
    }

    public void setStaticSoltcount(Integer staticSoltcount) {
        this.staticSoltcount = staticSoltcount;
    }

    public Solts getStaticVars() {
        return staticVars;
    }

    public void setStaticVars(Solts staticVars) {
        this.staticVars = staticVars;
    }

    public ClassObject getClazzObject() {
        return clazzObject;
    }

    public void setClazzObject(ClassObject clazzObject) {
        this.clazzObject = clazzObject;
    }


    public String javaName() {
        return name.replaceAll("/",".");
    }

    public Method getMethod(String name,String descriptor){
        for(Method method : methods){
            if(method.getName().equals(name) && method.getDescriptor().equals(descriptor)){
                return method;
            }
        }
        return null;
    }

    public Method getStaticMethod(String name,String descriptor){
        for(Method method : methods){
            if(method.getName().equals(name) && method.getDescriptor().equals(descriptor)){
                return method;
            }
        }
        return null;
    }

    public String getSourceFile(ClassFile classFile){
        for(Attribute attribute : classFile.getAttributes().attrs){
            if(attribute instanceof SourceFile_attribute){
//                return attribute.
            }
        }
        return "Unknow";
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}
