package com.wyclass.BufferIOputStream;

import java.io.*;

public class Copymp4Demo02 {
    public static void main(String[] args) throws IOException {
        //记录开始时间
        long startTime = System.currentTimeMillis();
        //复制视频
        method4();
        //记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时"+(endTime-startTime)+"毫秒");
    }

    //使用字节流一次读一个字节    共耗时70790毫秒
    public static void method1() throws IOException {
        FileInputStream  fis = new FileInputStream("D:\\loading\\NetProgramming\\text\\java.mp4");
        FileOutputStream fos = new FileOutputStream("java.mp4");
        int by;
        while((by=fis.read())!=-1){
            fos.write(by);
        }
        fis.close();
        fos.close();
}

    //使用字节流一次读取一个数组  共耗时99毫秒
    public static void method2() throws IOException {
        FileInputStream  fis = new FileInputStream("D:\\loading\\NetProgramming\\text\\java.mp4");
        FileOutputStream fos = new FileOutputStream("java.mp4");
        byte[] bys = new byte[1024];
        int len ;
        while ((len=fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
    }

    //使用字节缓冲流读取一次读一个字节  共耗时211毫秒
    public static void method3() throws IOException {
        BufferedInputStream bis= new BufferedInputStream(new FileInputStream("D:\\loading\\NetProgramming\\text\\java.mp4"));
        BufferedOutputStream  bos = new BufferedOutputStream(new FileOutputStream("java.mp4"));
        int by ;
        while ((by=bis.read())!=-1){
            bos.write(by);
        }
        bis.close();
        bos.close();

    }

    //使用缓冲字节流一次读取一个数组  共耗时23毫秒
    public static void method4() throws IOException {
        BufferedInputStream bis= new BufferedInputStream(new FileInputStream("D:\\loading\\NetProgramming\\text\\java.mp4"));
        BufferedOutputStream  bos = new BufferedOutputStream(new FileOutputStream("java.mp4"));
        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bis.close();
        bos.close();
    }
}
