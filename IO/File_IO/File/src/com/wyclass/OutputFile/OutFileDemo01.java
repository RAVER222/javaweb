package com.wyclass.OutputFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
   FileOutputStream​(File file) 创建文件输出流以写入由指定的 File对象表示的文件。
   FileOutputStream​(String name) 创建文件输出流以指定的名称写入文件。

   void write​(byte[] b) 将 b.length字节从指定的字节数组写入此文件输出流。
   void write​(byte[] b, int off, int len) 将 len字节从指定的字节数组开始，从偏移量 off开始写入此文件输出流。
   void write​(int b) 将指定的字节写入此文件输出流。
*/
public class OutFileDemo01 {
     public static void main(String[] args) throws IOException {
        //FileOutputStream​(File file) 创建文件输出流以写入由指定的 File对象表示的文件。
        FileOutputStream fos = new FileOutputStream("fos.txt");

        //FileOutputStream​(String name) 创建文件输出流以指定的名称写入文件。
        //File f1 = new File("fos.txt");
        //final FileOutputStream fos2 = new FileOutputStream(f1);

        //FileOutputStream fos2= new FileOutputStream(new File("fos.txt"));
/*
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.write(100);
        fos.write(101);
*/

      //void write​(byte[] b) 将 b.length字节从指定的字节数组写入此文件输出流。
      //byte[] bys =  {97,98,99,100,101};
        byte[] bytes = "abcde".getBytes();

      //void write​(byte[] b, int off, int len) 将 len字节从指定的字节数组开始，从偏移量 off开始写入此文件输出流。
        fos.write(bytes,0,bytes.length);
     }
}
