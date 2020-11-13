package com.wyclass.File;

import java.io.File;
import java.io.IOException;
/*
          File类创建功能：boolean createNewFile​() 当且仅当具有该名称的文件尚不存在时，
          原子地创建一个由该抽象路径名命名的新的空文件。
          boolean mkdir​() 创建由此抽象路径名命名的目录。
          boolean mkdirs​() 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录。
*/
public class FileDemo01 {
    public static void main(String[] args) throws IOException {
        //1.需求1：D:\loading\网络编程\text在目录下创建一个文件java.txt
        File fl =  new File("D:\\loading\\NetProgramming\\text\\java.txt");
        System.out.println(fl.createNewFile());
        //2.我在D:\loading\网络编程\text目录下创建一个目录javaSE
        File f2 = new File("D:\\loading\\NetProgramming\\text\\JavaSE");
        System.out.println(f2.mkdir());
        //3.在D:\loading\网络编程\text目录下创建一个多级目录JAVAWEB\HTML
        File f3=  new File("D:\\loading\\NetProgramming\\text\\JavaWEB\\HTML");
        System.out.println(f3.mkdirs());
        //4.在D:\loading\网络编程\text目录下创建一个文件javase.txt
        File  f4 = new File("D:\\loading\\NetProgramming\\text\\JavaSE.txt");
        //System.out.println(f4.mkdir());
        System.out.println(f4.createNewFile());
    }
}
