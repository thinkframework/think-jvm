package org.think.jvm;

import org.think.jvm.classpath.ClazzPath;
import org.think.jvm.exceptions.VMException;
import org.think.jvm.jnative.Registry;
import org.think.jvm.rtad.Frame;
import org.think.jvm.rtad.Thread;
import org.think.jvm.rtad.heap.ArrayObject;
import org.think.jvm.rtad.heap.Clazz;
import org.think.jvm.rtad.heap.ClazzLoader;
import org.think.jvm.rtad.heap.Method;

/**
 * @author lixiaobin
 * @since 2017/3/30
 */
public class JVM {
    private Cmd cmd;
    private ClazzLoader clazzLoader;
    private Thread thread;

    private static JVM instance;

    public JVM(){
        Registry.getInstance().init();
    }

    public static JVM getInstance(){
        if(instance == null){
            instance = new JVM();
        }
        return instance;
    }


    public JVM(Cmd cmd){
        this.cmd = cmd;
        this.clazzLoader = new ClazzLoader(ClazzPath.parse(cmd.getXjre(),cmd.getCpOption()));
        this.thread = new Thread();
    }


    public JVM Cmd(Cmd cmd){
        this.cmd = cmd;
        this.clazzLoader = new ClazzLoader(ClazzPath.parse(cmd.getXjre(),cmd.getCpOption()));
        this.thread = new Thread();
        return this;
    }



    public void initJVM(){
        //TODO
    }

    public void execMain(){
        String className = cmd.getClazz().replaceAll("\\.","/");
        Clazz clazz = clazzLoader.loadClass(className);
        Method method = clazz.getMainMethod();
        Object args = createArgsArray(clazzLoader,cmd.getArgs());

        Frame frame = thread.newFrame(method);
        frame.getLocalVars().setRef(0,args);
        thread.pushFrame(frame);

        Interpreter.getInstance().interpret(thread);
    }

    public void start(){
        initJVM();
        execMain();
    }


    public Object createArgsArray(ClazzLoader clazzLoader,String[] args){
        Clazz stringClass =clazzLoader.loadClass("java/lang/String");
        if(args == null){
            return null;
        }
        ArrayObject arrayObject = stringClass.ArrayClass().newArray(args.length);
        for(int i=0;i<args.length;i++){
            arrayObject.setRef(i,args[i]);
        }
        return arrayObject;
    }

}
