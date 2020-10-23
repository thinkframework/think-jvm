package io.github.thinkframework.jvm.rtad.heap;

import io.github.thinkframework.jvm.classfile.ClassFile;
import io.github.thinkframework.jvm.classpath.ClazzPath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClazzLoader {
    ClazzPath clazzPath;

    //方法区
    Map<String,Clazz> classMap = new HashMap<String,Clazz>();

    private ClazzLoader(){

    }

    public ClazzLoader(ClazzPath clazzPath){
        this.clazzPath = clazzPath;
        loadBaseClass();
        loadPrimitiveClasses();
    }

    public void loadBaseClass(){
        Clazz clazzObject = loadClass("java/lang/Class");
        for(Map.Entry<String,Clazz> entry : classMap.entrySet()){
            Clazz clazz = entry.getValue();
            clazz.setClazzObject(clazzObject.newObject());
            clazz.getClazzObject().setExtra(clazz);
        }
    }


    public void loadPrimitiveClasses(){
        Map<String,String> primitiveTypes = new HashMap<String,String>();
        primitiveTypes.put("void","V");
        primitiveTypes.put("boolean","Z");
        primitiveTypes.put("byte","B");
        primitiveTypes.put("short","S");
        primitiveTypes.put("int","I");
        primitiveTypes.put("long","J");
        primitiveTypes.put("char","C");
        primitiveTypes.put("float","F");
        primitiveTypes.put("double","D");
        for(String className : primitiveTypes.keySet()){
            loadPrimitiveClass(className);
        }
    }

    public Clazz loadPrimitiveClass(String className){
        Map<String,String> primitiveTypes = new HashMap<String,String>();
        primitiveTypes.put("void","V");
        primitiveTypes.put("boolean","Z");
        primitiveTypes.put("byte","B");
        primitiveTypes.put("short","S");
        primitiveTypes.put("int","I");
        primitiveTypes.put("long","J");
        primitiveTypes.put("char","C");
        primitiveTypes.put("float","F");
        primitiveTypes.put("double","D");
        Clazz clazz = new Clazz(new AccessFlags(AccessFlags.ACC_PUBLIC),
                className,
                this,
                null,
                null,
                true);
        Clazz clazzObject = loadClass("java/lang/Class");
        clazz.setClazzObject(clazzObject.newObject());
        clazz.getClazzObject().setExtra(clazzObject);
        classMap.put(clazz.getName(),clazz);
        return clazz;
    }

    public Clazz loadClass(String className){
        if(classMap.containsKey(className)){
            return classMap.get(className);
        }else {
            Clazz clazz;
            if(className.charAt(0) == '['){
                clazz = loadArrayClass(className);
            }else {
                clazz = loadNonArrayClass(className);
            }
            Clazz clazzObject = loadClass("java/lang/Class");
            clazz.setClazzObject(clazzObject.newObject());
            clazz.getClazzObject().setExtra(clazz);
            return clazz;
        }

    }
    public Clazz loadArrayClass(String className){
        String arrayClassName = getArrayClassName(className);
        Clazz clazz = new Clazz(new AccessFlags(AccessFlags.ACC_PUBLIC),
                className,
                this,
                loadClass("java/lang/Object"),
                new Clazz[]{
                        loadClass("java/lang/Cloneable"),
                        loadClass("java/io/Serializable")
                },
                true);

        classMap.put(clazz.getName(),clazz);
        return clazz;
    }

    public String getArrayClassName(String className){
        Map<String,String> primitiveTypes = new HashMap<String,String>();
        primitiveTypes.put("void","V");
        primitiveTypes.put("boolean","Z");
        primitiveTypes.put("byte","B");
        primitiveTypes.put("short","S");
        primitiveTypes.put("int","I");
        primitiveTypes.put("long","J");
        primitiveTypes.put("char","C");
        primitiveTypes.put("float","F");
        primitiveTypes.put("double","D");

        if(className.charAt(0) == '['){
            return className;
        }if(primitiveTypes.get(className) != null){
            return primitiveTypes.get(className);
        }else {
            return "L"+className+";";
        }
    }

    public Clazz loadNonArrayClass(String className){
        byte[] data = readClass(className);
        Clazz clazz = defineClass(data);
        link(clazz);
        return clazz;
    }

    public byte[] readClass(String className){
        return clazzPath.readClass(className);
    }

    public Clazz defineClass(byte[] data){
        Clazz clazz = parseClass(data);
        clazz.setClazzLoader(this);
        resolveSuperClass(clazz);
        resolveInterfaces(clazz);
        classMap.put(clazz.getName(),clazz);
        return clazz;
    }

    public Clazz parseClass(byte[] data){
        Clazz clazz = null;
        try {
            ClassFile classFile = new ClassFile(new ByteArrayInputStream(data));
            clazz = new Clazz(classFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public void resolveSuperClass(Clazz clazz){
        if (!"java/lang/Object".equals(clazz.getName())){
            clazz.setSuperClazz(clazz.getClazzLoader().loadClass(clazz.getSupertClassName()));
        }
    }

    public void resolveInterfaces(Clazz clazz){
        clazz.setInterfaces(new Clazz[clazz.getInterfaceNames().length]);
        for(int i=0;i<clazz.getInterfaceNames().length;i++){
            clazz.setInterface(i,clazz.getClazzLoader().loadClass(clazz.getInterfaceNames()[i]));
        }
    }


    public void link(Clazz clazz){
        verify(clazz);
        prepare(clazz);
    }

    public void verify(Clazz clazz){
    }

    public void prepare(Clazz clazz){
        calcInstanceFieldSlotIds(clazz);
        calcStaticFieldSlotIds(clazz);
        allocAndInitStaticVars(clazz);
    }

    public void calcInstanceFieldSlotIds(Clazz clazz){
        int soltId = 0;
        if(clazz.getSuperClazz() != null){
            soltId = clazz.getSuperClazz().getInstanceSlotCount();
        }
        for(Field field : clazz.getFields()){
            if(!field.isStatic()){
                field.soltId = soltId;
                soltId++;
                if(field.isLongOrDouble()){
                    soltId++;
                }
            }
        }
        clazz.setInstanceSlotCount(soltId);
    }

    public void calcStaticFieldSlotIds(Clazz clazz){
        int soltId = 0;
        for(Field field : clazz.getFields()){
            if(field.isStatic()){
                field.soltId = soltId;
                soltId++;
                if(field.isLongOrDouble()){
                    soltId++;
                }
            }
        }
        clazz.setStaticSoltcount(soltId);
    }

    public void allocAndInitStaticVars(Clazz clazz){
        clazz.setStaticVars(new Solts(clazz.getStaticSoltcount()));
        for(Field field : clazz.getFields()){
            if(field.isStatic() && field.isFinal()){
                initStaticFinalVar(clazz,field);
            }
        }
    }

    public void initStaticFinalVar(Clazz clazz, Field field){
        Solts staticVars = clazz.getStaticVars();
        ConstantPool cp = clazz.getConstantPool();
        int id = field.soltId;
        String descriptor = field.descriptor;
        Integer index = field.constValueIndex;
        switch (descriptor){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                Integer integer = (Integer)cp.getConstant(index).getValue();
                staticVars.setInt(id,integer);
                break;
            case "J":
                Long aLong = (Long)cp.getConstant(index).getValue();
                staticVars.setLong(id,aLong);
                break;
            case "F":
                Float aFloat = (Float)cp.getConstant(index).getValue();
                staticVars.setFloat(id,aFloat);
                break;
            case "D":
                Double aDouble = (Double)cp.getConstant(index).getValue();
                staticVars.setDouble(id,aDouble);
                break;
            case "Ljava/lang/String":
                String string = (String)cp.getConstant(index).getObject();
                staticVars.setRef(id,string);
                break;
        }
    }
}
