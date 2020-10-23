package org.think.jvm.classpath;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.junit.Assert.*;
/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClazzPathTest {
    protected static final Logger log = LoggerFactory.getLogger(ClazzPathTest.class);
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
        byte[] bytes = clazzPath.readClass("classes.MyObject");
        assertNotNull(bytes);
    }



    @Test
    public void test(){
        ClazzPath clazzPath = ClazzPath.parse();
        byte[] bytes = clazzPath.readClass("java.lang.Object");
        Assert.assertNotNull(bytes);
    }


    @Test
    public void testWithJre(){
        ClazzPath clazzPath = ClazzPath.parse();
        byte[] bytes = clazzPath.readClass("java.lang.Object");
        Assert.assertNotNull(bytes);
    }

    @Test
    public void testWithJreAndClassPath(){
        ClazzPath clazzPath = ClazzPath.parse();
        byte[] bytes = clazzPath.readClass("java.lang.Object");
        Assert.assertNotNull(bytes);
    }


    @Test
    public void testClassPath(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
        String path = System.getProperty("user.dir")+ File.separator+"lib";
        ClazzPath clazzPath = ClazzPath.parse(null,path);
        log.debug("BootClassPath:"+clazzPath.getBootClassPath());
        log.debug("ExtClassPath:"+clazzPath.getExtClassPath());
        log.debug("UserClassPath:"+clazzPath.getUserClassPath());
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
