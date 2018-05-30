package org.think.jvm.instructions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.think.jvm.classfile.ClassFile;
import org.think.jvm.classfile.ClassFileTest;
import org.think.jvm.classfile.ClassFileMethod;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * @author lixiaobin
 * @since 2017/3/29
 */
public class InstructionsTest {
    Log log = LogFactory.getLog(getClass());
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
                    log.debug(InstructionFactory.newInstruction(_byte));
                }catch (Exception e){
                    log.error(e.getMessage(),e);
                }
            }
        }
    }
}
