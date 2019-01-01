package org.think.jvm.classfile;

import java.io.IOException;
import java.util.Iterator;

/**
 * @see com.sun.tools.classfile.Attributes
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Attributes implements Iterable{
    public Attribute[] attrs;

    public Attributes(ClassFileReader classFileReader) throws IOException {
        int attrs_count = classFileReader.readUnsignedShort();
        this.attrs = new Attribute[attrs_count];

        for(int i = 0; i < attrs_count; i++) {
            Attribute attribute = Attribute.read(classFileReader);
            this.attrs[i] = attribute;
        }
    }

    public Attribute get(int i){
        return attrs[i];
    }

    public Attribute get(Integer index){
        return attrs[index];
    }

    public Integer length(){
        return attrs.length;
    }
    @Override
    public Iterator iterator() {
        return null;
    }
}
