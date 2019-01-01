package org.think.jvm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 命令行工具
 * @author lixiaobin
 */
public class Cmd {

    public static Log log = LogFactory.getLog(Cmd.class);

    private String xjre;
    private Boolean helpFlag;
    private Boolean versionFlag;
    private Boolean verboseClassFlag;
    private Boolean verboseInstFlag;
    private String cpOption;
    private String clazz;
    private String[] args = new String[0];

    public Cmd() {
        this.helpFlag = false;
        this.versionFlag = false;
        this.cpOption = cpOption;
        this.clazz = clazz;
        this.args = args;
    }

    public String getXjre() {
        return xjre;
    }

    public void setXjre(String xjre) {
        this.xjre = xjre;
    }

    public Boolean getHelpFlag() {
        return helpFlag;
    }

    public void setHelpFlag(Boolean helpFlag) {
        this.helpFlag = helpFlag;
    }

    public Boolean getVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(Boolean versionFlag) {
        this.versionFlag = versionFlag;
    }

    public Boolean getVerboseClassFlag() {
        return verboseClassFlag;
    }

    public void setVerboseClassFlag(Boolean verboseClassFlag) {
        this.verboseClassFlag = verboseClassFlag;
    }

    public Boolean getVerboseInstFlag() {
        return verboseInstFlag;
    }

    public void setVerboseInstFlag(Boolean verboseInstFlag) {
        this.verboseInstFlag = verboseInstFlag;
    }

    public String getCpOption() {
        return cpOption;
    }

    public void setCpOption(String cpOption) {
        this.cpOption = cpOption;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }


    public Cmd clazz(String clazz) {
        this.clazz = clazz;
        return this;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }


    public Cmd args(String[] args) {
        this.args = args;
        return this;
    }


    public static void parseCmd() {
        try {
        }catch (Exception e){
            System.out.println("Usage: $s [-options] class [-args]");
        }
    }

    public static void printUsage(){

    }

    public Cmd(String[] arg){
        try {
            String[] args = arg[0].split(" ");
            Cmd cmd =new Cmd();
            int i=0;//参数位置,位置数量不固定
            while(args[i] != null && args[i].startsWith("-")) {//可选参数
                if ("-version".equals(args[i])) {
                    cmd.versionFlag = true;
                    log.debug("version 0.0.1");
                    return;
                }else
                if ("-help".equals(args[i])) {
                    cmd.helpFlag = true;
                    log.debug("help");
                    return;
                }else
                if (args[i].startsWith("-cp") || args[i].startsWith("-classpath")) {
                    cmd.cpOption = args[i];
                    log.debug("classpath:" + cmd.cpOption);
                }
                i++;
            }
            cmd.clazz = args[i];
            if(cmd.clazz != null) {
                log.debug("class:"+cmd.clazz);
            }
            if(args.length-1 == ++i && args[i] != null) {//可选参数
                cmd.args = args[i].split("-");
                for (int j=0;j<cmd.args.length;j++) {
                    log.debug("args["+j+"]:" + cmd.args[j]);
                }
            }
        } catch (NullPointerException e){
            log.error("",e);
        }catch (Exception e) {
            log.error("",e);
        }
    }
}
