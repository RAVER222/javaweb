package com.wyclass.SystemIn;

import java.io.PrintStream;

/*
 public static final PrintStream out“标准”输出流。 此流已经打开并准备好接受输出数据
  通常，此流对应于显示输出或由主机环境或用户指定的另一个输出目标。
  */
public class SystemOutDemo {
    public static void main(String[] args) {
        PrintStream out = System.out;

        //能够方便打印各种数据值
//        out.print("hello");
//        out.print(100);

        out.println("hello");
        out.println(100);



    }
}
