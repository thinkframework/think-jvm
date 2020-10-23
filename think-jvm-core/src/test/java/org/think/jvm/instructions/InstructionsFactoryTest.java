package org.think.jvm.instructions;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.think.jvm.classfile.ClassFile;
import org.think.jvm.classfile.ClassFileMethod;
import org.think.jvm.classfile.ClassFileTest;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * @author lixiaobin
 * @since 2017/3/29
 */
public class InstructionsFactoryTest {
    protected static final Logger log = LoggerFactory.getLogger(InstructionsFactoryTest.class);
    @Test
    public void test() throws IOException{
        InputStream inputStream = ClassFileTest.class.getClassLoader().getResourceAsStream("classes/book/ch05/ClassFileTest.class");
        ClassFile classFile =new ClassFile(inputStream);
        assertTrue(inputStream.read(new byte[1]) == -1);
        ClassFileMethod[] classFileMethods = classFile.getClassFileMethods();
        for(ClassFileMethod classFileMethod : classFileMethods){
            byte[] bytes = classFileMethod.getCode();
            for(byte _byte : bytes){
                try {
                    log.debug("{}",InstructionFactory.newInstruction(_byte));
                }catch (Exception e){
                    log.error(e.getMessage(),e);
                }
            }
        }
    }
}
