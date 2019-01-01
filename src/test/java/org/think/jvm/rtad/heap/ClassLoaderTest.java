package org.think.jvm.rtad.heap;

import org.junit.Assert;
import org.junit.Test;
import org.think.jvm.Interpreter;
import org.think.jvm.classpath.ClazzPath;
import org.think.jvm.exceptions.VMException;

import java.io.File;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassLoaderTest {
//    @Test
//    public void testMyObject(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.MyObject");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//    @Test
//    public void testInvokeDemo(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.InvokeDemo");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//    @Test
//    public void testFibonacci(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.FibonacciTest");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//    @Test
//    public void testArrayDemo(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.ArrayDemo");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//    @Test
//    public void testBubbleSort(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.BubbleSortTest");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//
//    @Test
//    public void testGetClass(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.getClassTest");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//    @Test
//    public void testClassFile(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.ClassFileTest");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//    @Test
//    public void testGauss(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.GaussTest");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//    @Test
//    public void testString(){
//        String path = System.getProperty("user.dir")+ File.separator+"target"+File.separator+"test-classes";
//        ClazzPath clazzPath = ClazzPath.parse(null,path);
//        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
//        Clazz clazz = clazzLoader.loadClass("classes.StringTest");
//        Method method = getMainMethod(clazz);
//        new Interpreter().interpret(method,null);
//
//        Assert.assertNotNull(clazz);
//    }
//
//
//    public Method getMainMethod(Clazz clazz) throws VMException {
//        for(Method method : clazz.getMethods()){
//            if(method.getAccessFlags().isStatic() && "main".equals(method.getName())){
//                return method;
//            }
//        }
//        throw new VMException("can't find main method.");
//    }
}
