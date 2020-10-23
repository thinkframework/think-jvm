package org.think.jvm.classpath;

import org.think.jvm.classfile.ClassFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ZipEntry extends Entity {
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
}
