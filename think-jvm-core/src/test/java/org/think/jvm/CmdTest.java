package org.think.jvm;

import org.junit.Test;

public class CmdTest {
    @Test
    public void testHelp(){
        new Cmd(new String[]{"-help"});
    }

    @Test
    public void testVersion(){
        new Cmd(new String[]{"-version"});
    }



    @Test
    public void testClassPath(){
        new Cmd(new String[]{"-cp=.:lib/log4j-core-2.8.2.jar java.lang.Object"});
    }


    @Test
    public void testNoClassPath(){
        new Cmd(new String[]{"java.lang.Object"});
    }

    @Test
    public void testArgs(){
        new Cmd(new String[]{"java.lang.Object abc"});
    }


    @Test
    public void testNoArgs(){
        new Cmd(new String[]{"java.lang.Object"});
    }
}
