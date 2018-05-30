package org.think.jvm;

import java.io.*;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Decompile {
    public static org.think.jvm.classfile.ClassFile decompile(InputStream inputStream)throws IOException {
        org.think.jvm.classfile.ClassFile classFile = new org.think.jvm.classfile.ClassFile(inputStream);

        byte[] eof = new byte[1];
        if(inputStream.read(eof) != -1){
            throw new IOException("解析异常,未解析到文件末尾.");
        }
        return classFile;
    }
}
