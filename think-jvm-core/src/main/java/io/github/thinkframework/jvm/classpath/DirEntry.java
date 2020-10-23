package io.github.thinkframework.jvm.classpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class DirEntry implements Entity {
    String path;
    public DirEntry(){

    }

    public DirEntry(String path){
        this.path = path;
    }


    public byte[] readClass(String className){
        try {
            File file = new File(path+File.separator+className);
            if(!file.exists()){
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            return toByteArray(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return path == null ? "" : new File(path).getAbsolutePath();
    }
}
