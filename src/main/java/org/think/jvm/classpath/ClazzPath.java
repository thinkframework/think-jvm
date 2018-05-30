package org.think.jvm.classpath;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;

/**
 * @author lixiaobin
 * @since 2017/3/23.
 */
public class ClazzPath {
    Log log = LogFactory.getLog(getClass());
    Entity bootClassPath;
    Entity extClassPath;
    Entity userClassPath;
    public byte[] readClass(String className){
        className = className.replaceAll("\\.","/")+".class";
        byte[] data;
        if((data = bootClassPath.readClass(className)) != null){
            return data;
        }
        if((data = extClassPath.readClass(className)) != null){
            return data;
        }
        if((data = userClassPath.readClass(className)) != null){
            return data;
        }
        return null;
    }


    public static ClazzPath parse(){
        return parse(null,null);
    }

    public static ClazzPath parse(String javahome, String classpath){
        String java_home = javahome != null ? javahome : System.getProperty("java.home");
        String user_dir = classpath != null ? classpath : System.getProperty("user.dir");
        ClazzPath clazzPath = new ClazzPath();
        clazzPath.parseBootAdnExtClassPath(java_home);
        clazzPath.parseUserClassPath(user_dir);
        return clazzPath;
    }

    public void parseBootAdnExtClassPath(String java_home){
        log.debug("java.home:"+java_home);
        String boot_class_path = java_home + File.separator + "lib"+ File.separator +"*";
        bootClassPath = new WildcardEntry(boot_class_path);
        String ext_class_path = java_home + File.separator + "lib"+ File.separator +"core"+ File.separator +"*";
        extClassPath = new WildcardEntry(ext_class_path);
    }


    public void parseUserClassPath(String classPath){
        log.debug("user.dir:"+classPath);
        userClassPath = new DirEntry(classPath);
    }
}
