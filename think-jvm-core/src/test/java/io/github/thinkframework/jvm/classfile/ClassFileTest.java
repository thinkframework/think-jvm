package io.github.thinkframework.jvm.classfile;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;
/**
 * @author lixiaobin
 * @since 2017/3/29
 */
public class ClassFileTest {
    protected static final Logger log = LoggerFactory.getLogger(ClassFileTest.class);
    @Test
    public void test() throws IOException{
        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
        InputStream inputStream = new FileInputStream(new File(path+File.separator+"classes/ClassFileTest.class"));
        ClassFile classFile =new ClassFile(inputStream);
        log.debug("magic:"+classFile.getMagic());
        log.debug("minorVersion:"+classFile.getMajorVersion());
        log.debug("majorVersion:"+classFile.getMinorVersion());
        log.debug("constantPool:"+classFile.getConstantPool());
        CPInfo[] cpInfos = classFile.getConstantPool().getPool();
        for(CPInfo cpInfo : cpInfos){
            log.debug("cpInfo:"+cpInfo);
        }
        log.debug("accessFlags:"+classFile.getAccessFlags());
        log.debug("thisClass:"+ cpInfos[classFile.getThisClass()]);
        log.debug("superClass:"+cpInfos[classFile.getSuperClass()]);
        log.debug("interfaces:"+classFile.getInterfaces());
        int[] interfaces = classFile.getInterfaces();
        for(int i : interfaces){
            log.debug("interfaces:"+cpInfos[i]);
        }
        log.debug("classFileFields:"+classFile.getClassFileFields());
        ClassFileField[] classFileFields = classFile.getClassFileFields();
        for(ClassFileField classFileField : classFileFields){
            log.debug("classFileFields:"+classFileField);
        }
        log.debug("classFileMethods:"+classFile.getClassFileMethods());
        ClassFileMethod[] classFileMethods = classFile.getClassFileMethods();
        for(ClassFileMethod classFileMethod : classFileMethods){
            log.debug("classFileMethods:"+classFileMethod);
            byte[] code = classFileMethod.getCode();
//            for(int i : code){
//                Instruction instruction =InstructionFactory.newInstruction(i);
//                log.debug("operations:"+instruction);
//            }
        }
        log.debug("attributes:"+classFile.getAttributes());
//        Attributes attributes = classFile.getAttributes();
//        for(int i : interfaces){
//            log.debug("interfaces:"+cpInfos[i]);
//        }
        assertTrue(inputStream.read(new byte[1]) == -1);
    }
}
