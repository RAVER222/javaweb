package com.wyclass.File;

import java.io.File;
import java.io.IOException;

/*
     File类删除功能:
        boolean delete​() 删除由此抽象路径名表示的文件或目录。
      */
public class FileDemo03 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("javase.txt");
        System.out.println(f1.createNewFile());

        //需求二:删除当前目录下的javase.txt文件
        System.out.println(f1.delete());

        //需求三:在当前木块的目录下创建ticast目录
        File f2  = new File("itcast");
        System.out.println(f2.mkdir());

        //需求四:删除当前模块的itcast目录
        System.out.println(f2.delete());

        //需求5:在当前木块下创建一个目录itcast,然后在目录下创建一个文件java.txt
        File f3 = new File("itcast");
        System.out.println(f3.mkdir());
        File f4 = new File("itcast\\java.txt");
        System.out.println(f4.createNewFile());

        //需求6:删除当前模块下的目录的itcast
        System.out.println(f4.delete());
        System.out.println(f3.delete());


    }
}
