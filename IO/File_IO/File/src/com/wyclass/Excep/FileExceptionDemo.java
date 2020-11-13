package com.wyclass.Excep;

import java.io.*;

public class FileExceptionDemo {
    public static void main(String[] args) throws IOException {

        method1();
        method2();
        method3();


    }




    //JDK7    JDK9try(fr,fw)...catch
    private static void method3() throws IOException {
        try (FileReader fr = new FileReader("fos.txt");
             FileWriter fw = new FileWriter("fos1.txt");) {
            int len;
            char[] bys = new char[1024];
            while ((len = fr.read(bys)) != -1) {
                fw.write(bys, 0, len);
            }
         } catch (IOException e){
            e.printStackTrace();
        }
    }

    //JDK1.6解法
    private static void method2() throws IOException {
        FileReader fr=null;
        FileWriter fw= null;
      try {
        fr = new FileReader("fos.txt");
        fw = new FileWriter("fos1.txt");
        int len;
        char[] bys = new char[1024];
        while ((len=fr.read(bys))!=-1){
            fw.write(bys,0,len);
         }
       }catch (IOException e){
          e.printStackTrace();
      }finally {
          fr.close();
          fw.close();
      }
    }


    private static void method1() throws IOException {
        FileReader fr = new FileReader("fos.txt");
        FileWriter fw = new FileWriter("fos1.txt");
        int len;
        char[] bys = new char[1024];
        while ((len=fr.read(bys))!=-1){
            fw.write(bys,0,len);
        }
        fr.close();
        fw.close();
    }


}
