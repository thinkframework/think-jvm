package org.think.jvm.classpath;

import org.think.jvm.classfile.ClassFile;
import org.think.jvm.rtad.heap.Field;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class CompositeEntry implements Entity {
    String path = "";
    List<Entity> entities = new ArrayList<Entity>();
    public CompositeEntry(){

    }

    public CompositeEntry(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].getAbsolutePath().contains(".jar")) {
                entities.add(newEntry(files[i].getAbsolutePath()));
                path+= files[i].getAbsolutePath() + ";";
            }
        }
        this.path = path;
    }

    public Entity newEntry(String path) {
        if (path.contains(":")) {//默认unix路径风格福
            return new CompositeEntry(path);
        }
        if (path.contains("*")) {
            return new WildcardEntry(path);
        }
        if (path.contains("jar")||
                path.contains("zip")) {
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }

    public byte[] readClass(String className){
        for(Entity entity:entities){
            byte[] bytes;
            if((bytes = entity.readClass(className)) !=null){
                return bytes;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entity entity : entities){
            stringBuffer.append(entity.toString()).append(";");
        }
        return stringBuffer.toString();
    }
}
