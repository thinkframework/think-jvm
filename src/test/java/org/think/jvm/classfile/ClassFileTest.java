package org.think.jvm.classfile;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.*;
/**
 * @author lixiaobin
 * @since 2017/3/29
 */
public class ClassFileTest {
    @Test
    public void test() throws IOException{
        InputStream inputStream = new FileInputStream(new File("ClassFileTest.class"));
        ClassFile classFile =new ClassFile(inputStream);
        assertTrue(inputStream.read(new byte[1]) == -1);
    }
}
