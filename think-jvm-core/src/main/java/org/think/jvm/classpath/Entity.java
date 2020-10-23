package org.think.jvm.classpath;

import org.think.jvm.classfile.ClassFile;

import java.io.*;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public interface Entity {

    String FileSeparator = File.separator;//路径风格福

    byte[] readClass(String className);


    default byte[] toByteArray(InputStream inputStream) throws IOException {
        int count;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while((count = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
