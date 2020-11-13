package com.wyclass.inputFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        int len ;
        byte[] bys=  new byte[1024];
        while((len=fis.read(bys))!=-1){
            System.out.println(new String(bys, 0, len));
        }

        //调用字节输入流对象的读数据方法
        //   byte[] bys= new byte[5];
/*
        //1.第一次读取数据
        int len =fis.read(bys);
        System.out.println(len);
        System.out.println(new String(bys));

        //2.第二次读取数据
         len =fis.read(bys);
        System.out.println(len);
        System.out.println(new String(bys));

        //2.第三次读取数据
        len =fis.read(bys);
        System.out.println(len);
        System.out.println(new String(bys));

 */
    }
}
