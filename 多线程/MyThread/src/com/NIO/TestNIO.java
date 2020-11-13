package com.NIO;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
    通过NIO实现文件IO

   */
public class TestNIO {
    @Test
    public void test1() throws IOException {
        //1.创建输出流
        FileOutputStream fos = new FileOutputStream("basic.txt");
        //2.从流中得到一个通道
        FileChannel fc = fos.getChannel();
        //3.提供一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //4.往缓冲区中存入数据
        String str="hello,nio";
        byteBuffer.put(str.getBytes());
        //将指针刷新到起始位置
        byteBuffer.flip();
        //6..把缓冲区写到通道中
        fc.write(byteBuffer);
        //7.关闭通道
        fos.close();
    }

    @Test
    public void test02() throws IOException {
        //1.创建一个输入流
        File file = new File("basic.txt");
        FileInputStream fis = new FileInputStream(file);
        //2.创建一个通道
        FileChannel fc = fis.getChannel();
        //3.在通道中创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //4.在通道中读取数据并存到缓存中
        fc.read(byteBuffer);
        byte[] array = byteBuffer.array();
        System.out.println(array.toString());
        fis.close();
    }

    @Test  //1.使用NIO实现文件复制
    public void test03() throws IOException {
        FileInputStream fis= new FileInputStream("basic.txt");
        FileOutputStream fos= new FileOutputStream("D:\\loading\\NetProgramming\\text\\java.txt");
        //2.得到两个通道
        FileChannel fil = fis.getChannel();
        FileChannel fol = fos.getChannel();

        //3.复制
        // abstract long transferFrom​(ReadableByteChannel src, long position, long count) 从给定的可读字节通道将字节传输到该通道的文件中。
        //fol.transferFrom(fil,0,fil.size());
        //abstract long transferTo​(long position, long count, WritableByteChannel target) 将该通道文件的字节传输到给定的可写字节通道。
        fil.transferTo(0,fil.size(),fol);
        fis.close();
        fos.close();
    }
}
