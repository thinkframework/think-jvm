package org.think.jvm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.think.jvm.classpath.ClazzPath;
import org.think.jvm.exceptions.VMException;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ClazzLoader;
import org.think.jvm.rtad.heap.Method;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class Main {
    Log log = LogFactory.getLog(getClass());

    Interpreter interpret = new Interpreter();
    ClazzLoader clazzLoader;
    ClazzPath clazzPath;
    public void start(String... args) throws VMException {
        String classpath=null;
        for(String arg : args){
            if(arg.startsWith("-cp=")){
                classpath = arg.substring("-cp=".length());
            }
        }
        clazzPath = ClazzPath.parse(null,classpath);
        clazzLoader = new ClazzLoader(clazzPath);
        String className = args[args.length-1];
        Clazz clazz = clazzLoader.loadClass(className.replaceAll("/","."));
        Method method = getMainMethod(clazz);
        interpret.interpret(method,args);
    }

    public Method getMainMethod(Clazz clazz) throws VMException{
        for(Method method : clazz.getMethods()){
            if(method.getAccessFlags().isStatic() && "main".equals(method.getName())){
                return method;
            }
        }
        throw new VMException("can't find main method.");
    }

    public void initVM(){
        Clazz vmClass = clazzLoader.loadClass("sum/misc/VM");

    }
}
