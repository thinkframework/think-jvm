package io.github.thinkframework.jvm.rtad.heap;

import io.github.thinkframework.jvm.classfile.ClassFile;
import io.github.thinkframework.jvm.classpath.ClazzPath;
import io.github.thinkframework.jvm.rtad.Thread;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassTest {

    protected static final Logger log = LoggerFactory.getLogger(ClassTest.class);

    @Test
    public void test() throws IOException {

        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
        InputStream inputStream = new FileInputStream(new File(path+File.separator+"classes/GaussTest.class"));
        ClassFile classFile = new ClassFile(inputStream);
        Clazz clazz = new Clazz(classFile);

        log.debug("accessFlag:"+clazz.getAccessFlags());
        log.debug("name:"+clazz.getName());
        log.debug("supertClassName:"+clazz.getSupertClassName());
        log.debug("constantPool:"+clazz.getConstantPool());
        Constant[] constants = clazz.getConstantPool().getConstants();
        for(Constant constant : constants){
            log.debug("constant:"+constant);
        }
    }

    @Test
    public void test2() throws IOException{

        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
        InputStream inputStream = new FileInputStream(new File(path+File.separator+"classes/Myob.class"));
        ClazzPath clazzPath= ClazzPath.parse(null,path);
        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
        Thread thread = new Thread();
//        Frame frame = thread.newFrame(clazz.getMainMethod());
//        thread.pushFrame(frame);
//        loop(thread);

    }
}
