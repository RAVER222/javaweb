package com.wyclass.SystemIn;

import java.io.FileNotFoundException;
import java.io.PrintStream;
  /*
     使用继承父类的方法写数据,查看的时候会转码;
     使用自己的特有方法写数据,查看的数据原样输出
   */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
          /*
           打印流的特点:
             只负责输出数据,不负责读取数据
             有自己的特有方法
           */
        //PrintStream​(String fileName) 使用指定的文件名创建新的打印流，无需自动换行。
        PrintStream ps = new PrintStream("ps.txt");

        ps.write(97);

        //写数据
        ps.println(97);
        ps.println(98);

    }
}
