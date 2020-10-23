package org.think.jvm.classpath;

import org.think.jvm.classfile.ClassFile;

import java.io.File;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class WildcardEntry extends CompositeEntry {
    String path;
    public WildcardEntry(){

    }

    public WildcardEntry(String path){
        this.path = path.substring(0,path.length()-1);
        File file = new File(this.path);
        File[] files = file.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].getAbsolutePath().contains(".jar")) {
                entities.add(newEntry(files[i].getAbsolutePath()));
            }
        }
    }


    public byte[] readClass(String className){
        return super.readClass(className);
    }
}
