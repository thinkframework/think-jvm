package org.think.jvm.classpath;

import org.think.jvm.classfile.ClassFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Entity {


    public byte[] readClass(String className){
        return null;
    }


    protected byte[] toByteArray(InputStream inputStream) throws IOException {
        int count;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while((count = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes);
        }
        return byteArrayOutputStream.toByteArray();
    }

//    protected byte[] toByteArray(OutputStream outputStream) throws IOException {
//        int count;
//        byte[] bytes = new byte[1024];
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        while((count = outputStream.read(bytes)) != -1){
//            byteArrayOutputStream.write(bytes);
//        }
//        return byteArrayOutputStream.toByteArray();
//    }
}
