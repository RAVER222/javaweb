package com.wyclass.ReadAndWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
   FileWriter用于写入字符流
 */
public class CopyJavaDemo01 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("fos.txt");
        FileWriter fw  = new FileWriter("fw.txt");

        int len;
//        while ((len =fr.read())!=-1){
//            fw.write((char) len);
//        }

        char[] bys =new char[1024];
        while ((len=fr.read(bys))!=-1){
             fw.write(bys,0,len);
        }

        fr.close();
        fw.close();
    }
}
