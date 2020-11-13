package com.wyclass.SystemIn;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
   打印字符流的构造方法
   PrintWriter​(String fileName) 使用指定的文件名创建一个新的PrintWriter，而不需要自动执行行刷新。
   PrintWriter​(Writer out, boolean autoFlush) 创建一个新的PrintWriter。
        autoFlush - 一个布尔值 如果为真，则println ， printf ，或format方法将刷新输出缓冲区
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        //PrintWriter​(String fileName) 使用指定的文件名创建一个新的PrintWriter，而不需要自动执行行刷新//
//        PrintWriter pw = new PrintWriter("pw.txt");
//        pw.write("hello");
//        pw.flush();
//        pw.write("\r\n");
//        pw.write("world");
//        pw.flush();

//        pw.println("hello");
//        pw.flush();
//        pw.println("world");
//        pw.flush();

        //PrintWriter​(Writer out, boolean autoFlush)
        PrintWriter pw = new PrintWriter(new FileWriter("pw.txt"), true);

        pw.println("hello");
        /*
        s pw.write("hello");
         pw.flush();
         pw.write("\r\n");
         */
        pw.println("world");
        pw.close();

    }
}
