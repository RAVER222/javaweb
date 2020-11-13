package com.wyclass.File;

import java.io.File;
/*
    File类的判断和获取功能:
       boolean isDirectory​() 测试此抽象路径名表示的文件是否为目录。
       boolean isFile​() 测试此抽象路径名表示的文件是否为普通文件。
       boolean exists​() 测试此抽象路径名表示的文件或目录是否存在。

       File getAbsoluteFile​() 返回此抽象路径名的绝对形式。
       String getPath​() 将此抽象路径名转换为路径名字符串。
       String getName​() 返回由此抽象路径名表示的文件或目录的名称。

       String[] list​() 返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录。
       File[] listFiles​() 返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件。
*/
public class FileDemo02 {
    public static void main(String[] args) {
       /*
         boolean isDirectory​() 测试此抽象路径名表示的文件是否为目录。
         boolean isFile​() 测试此抽象路径名表示的文件是否为普通文件。
         boolean exists​() 测试此抽象路径名表示的文件或目录是否存在。
        */
        File f = new File("D:\\loading\\NetProgramming\\text\\JavaSE\\java.txt");
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.exists());

        /*
        File getAbsoluteFile​() 返回此抽象路径名的绝对形式。
        String getPath​() 将此抽象路径名转换为路径名字符串。
        String getName​() 返回由此抽象路径名表示的文件或目录的名称。
         */
        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getPath());
        System.out.println(f.getName());
        System.out.println("--------------");

        /*
          String[] list​() 返回一个 字符串数组，命名由此抽象路径名表示的目录中的文件和目录。
          File[] listFiles​() 返回一个 抽象路径名数组，表示由该抽象路径名表示的目录中的文件。
         */
        File f2 = new File("D:\\loading\\NetProgramming\\text");
        String[] list = f2.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-------------");
        File[] listFiles = f2.listFiles();
        for (File listFile : listFiles) {
            System.out.println(listFile.getName());
        }
    }
}
