package org.think.jvm.rtad.heap;

import org.think.jvm.classpath.ClazzPath;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class ClassLoaderTest {
    public void test(){
        ClazzPath clazzPath = ClazzPath.parse();
        ClazzLoader clazzLoader = new ClazzLoader(clazzPath);
        Clazz clazz = clazzLoader.loadClass("classes.book.ch05.MyObject");
    }
}
