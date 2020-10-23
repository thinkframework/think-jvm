package io.github.thinkframework.jvm.classfile;

import io.github.thinkframework.jvm.classfile.attribute.ConstantValue_attribute;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiaobin
 * @since 2017/3/14.
 */
public class ClassFileField extends CliassFileMember {

    ClassFileField(ClassFileReader classFileReader) throws IOException {
        super(classFileReader);
    }


    Map map = new HashMap();
    public ClassFileField(){
        map.put("B","byte");
        map.put("S","short");
        map.put("C","char");
        map.put("I","int");
        map.put("J","long");
        map.put("F","float");
        map.put("D","double");
    }

    public Integer getContastValue(){
        for(Attribute attribute : attributes.attrs){
            if(attribute instanceof ConstantValue_attribute){
                return ((ConstantValue_attribute)attribute).getConstantvalueIndex();
            }
        }
        return 0;
    }
//    @Override
//    public String toString() {
//        return "ClassFileField{" +
//                "map=" + map +
//                '}';
//    }
}
