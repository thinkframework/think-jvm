package org.think.jvm;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaobin
 * @since 2017/3/24
 */
public class FileTest {
    protected static final Logger log = LoggerFactory.getLogger(FileTest.class);
    @Test
    public void test2() throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("");
        FileReader fileReader = new FileReader("optcode.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String line;
        while( (line = bufferedReader.readLine()) != null){
            if(StringUtils.isNotBlank(line.trim())) {
                if ("0x60".equals(line.trim())) {
                    System.out.println();
                }
                list.add(line.trim());
            }
        }
        for(int i=0;i<list.size();){
            System.out.print(list.get(i++));
            System.out.print("\t");
            System.out.print(list.get(i++));
            System.out.print("\t");
            System.out.println(list.get(i++));
        }
    }


    @Test
    public void test9() throws IOException{
//        FileInputStream fileInputStream = new FileInputStream("");
        FileReader fileReader = new FileReader("optcode.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String line;
        while( (line = bufferedReader.readLine()) != null){
            if(StringUtils.isNotBlank(line.trim())) {
                System.out.println(line.trim());
            }
        }
    }

    @Test
    public void test3() throws IOException{
//        FileInputStream fileInputStream = new FileInputStream("");
        FileReader fileReader = new FileReader("optcode.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String line;
        while( (line = bufferedReader.readLine()) != null){
            if(StringUtils.isNotBlank(line.trim())) {
                if ("0x60".equals(line.trim())) {
                    System.out.println();
                }
                list.add(line.trim());
            }
        }
        for(int i=0;i<list.size();){
            String a = list.get(i++);
            String b = list.get(i++);
            String c = list.get(i++);

            System.out.print("/*\n");
            System.out.print("*"+c+"\n");
            System.out.print("*/\n");
            System.out.print("public static final int "+b.toUpperCase());
            System.out.print(" = ");
            System.out.print(a);
            System.out.println(";\n");
//            System.out.println(Integer.parseInt(a.substring(2),16));
        }
    }

    @Test
    public void testSwitch() throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("");
        FileReader fileReader = new FileReader("optcode.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String line;
        while( (line = bufferedReader.readLine()) != null){
            if(StringUtils.isNotBlank(line.trim())) {
                list.add(line.trim());
            }
        }
        for(int i=0;i<list.size();){
            String a = list.get(i++);
            String b = list.get(i++);
            String c = list.get(i++);

            System.out.println("case Const."+b.toUpperCase()+":");
            System.out.println("\treturn new "+b.toUpperCase()+"();");
//            System.out.println(";\n");
//            System.out.println(Integer.parseInt(a.substring(2),16));
        }
    }

    @Test

    public void testFile() throws IOException{
//        FileInputStream fileInputStream = new FileInputStream("");
        FileReader fileReader = new FileReader("optcode.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String line;
        while( (line = bufferedReader.readLine()) != null){
            if(StringUtils.isNotBlank(line.trim())) {
                list.add(line.trim());
            }
        }
        for(int i=0;i<list.size();){

            String a = list.get(i++);
            String b = list.get(i++);

            String c = list.get(i++);
            File file = new File("/Users/lixiaobin/Desktop/file/"+b.toUpperCase()+".java");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("package org.think.jvm.instructions;\n\n");
            fileWriter.write("import org.think.jvm.Instruction;\n");
            fileWriter.write("import org.think.jvm.Visitor;\n\n");
            fileWriter.write("/*\n");
            fileWriter.write("*"+c+"\n");
            fileWriter.write("*@author lixiaobin\n");
            fileWriter.write("*/\n");
            fileWriter.write("public class "+ b.toUpperCase()+" implements Instruction {\n");
            //fileWriter.write("\tpublic void fetchOperands(ByteCodeReader byteCodeReader){\n\t\n\t}\n");
            fileWriter.write("\t@Override\n");
            fileWriter.write("\tpublic void accept(Visitor visitor){\n\t\n\t}\n\n");
            fileWriter.write("\tpublic void execute(Visitor visitor){\n\t\n\t}\n");
            fileWriter.write("}\n");
            fileWriter.close();
        }
    }

    @Test
    public void testGetResource(){
        log.debug("{}",FileTest.class.getResource(""));
        log.debug("{}",FileTest.class.getResource("/"));
        log.debug("{}",FileTest.class.getClassLoader().getResource(""));
        log.debug("{}",FileTest.class.getClassLoader().getResource("/"));
    }
}
