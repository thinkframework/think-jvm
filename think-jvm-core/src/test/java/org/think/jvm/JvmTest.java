package org.think.jvm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class JvmTest {

    Cmd cmd;

    @Before
    public void setup(){
        cmd = new Cmd();
        cmd.setCpOption(System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes");
    }



    @Test
    public void testMyObject(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.MyObject"))
                .start();
    }

    @Test
    public void testInvokeDemo(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.InvokeDemo"))
                .start();
    }


    @Test
    public void testFibonacci(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.FibonacciTest"))
                .start();
    }


    @Test
    public void testArrayDemo(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.ArrayDemo"))
                .start();
    }


    @Test
    public void testBubbleSort(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.BubbleSortTest"))
                .start();
    }



    @Test
    public void testGetClass(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.getClassTest"))
                .start();
    }


    @Test
    public void testClassFile(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.ClassFileTest"))
                .start();
    }


    @Test
    public void testGauss(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.GaussTest"))
                .start();
    }


    @Test
    public void testString(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.StringTest"))
                .start();
    }



    @Test
    public void tesParseInt(){
        JVM.getInstance()
                .Cmd(cmd.clazz("classes.ParseIntTest").args(new String[]{"abc"}))
                .start();
    }

}
