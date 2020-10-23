package io.github.thinkframework.jvm.classpath;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ZipEntry implements Entity {
    String path;
    public ZipEntry(){

    }

    public ZipEntry(String path){
        this.path = path;
    }


    public byte[] readClass(String className){
        try {
            ZipFile zipFile = new ZipFile(path);
            java.util.zip.ZipEntry  zip = zipFile.getEntry(className);
            if(zip != null) {
                InputStream inputStream = zipFile.getInputStream(zip);
                return toByteArray(inputStream);
            }
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
