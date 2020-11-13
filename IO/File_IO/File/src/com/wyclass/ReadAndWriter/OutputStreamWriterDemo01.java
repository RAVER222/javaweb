package com.wyclass.ReadAndWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
  void write​(char[] cbuf, int off, int len) 写入字符数组的一部分。
  void write​(int c) 写一个字符
  void write​(String str, int off, int len) 写一个字符串的一部分。
 */
public class OutputStreamWriterDemo01 {
    public static void main(String[] args) throws IOException {
        //OutputStreamWriter​(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter。
         OutputStreamWriter ows= new OutputStreamWriter(new FileOutputStream("ows.txt"));
//         ows.write(97);
//         //void flush​() 刷新流。
//         ows.flush();
//         ows.write(98);
//         ows.flush();
//         ows.write(99);
          char[] chs = {'a','b','c','d','e'};
          //ows.write("abced");
          ows.write(chs,2,4);
          //ows.write(chs,0,3);
          ows.close();
    }
}
