package org.think.jvm.classpath;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;
/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClazzPathTest {
    Log log = LogFactory.getLog(getClass());
    @Test
    public void testBootClassPath(){
        ClazzPath clazzPath = ClazzPath.parse();
        byte[] bytes = clazzPath.readClass("java.lang.Object");
        assertNotNull(bytes);
    }

    @Test
    public void testUserClassPath(){
        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
        ClazzPath clazzPath = ClazzPath.parse(null,path);
        byte[] bytes = clazzPath.readClass("classes.book.ch05.MyObject");
        assertNotNull(bytes);
    }

    @Test
    public void testJavaClassPath(){
        log.debug(System.getProperty("java.class.path"));
    }


    @Test
    public void testUserDir(){
        log.debug(System.getProperty("user.dir"));
    }
}
