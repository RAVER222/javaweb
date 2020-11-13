package com.wyclass.BufferIOputStream;

import java.io.*;
import java.nio.Buffer;

public class BufferFileDemo01 {
    public static void main(String[] args) throws Exception {
/*
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));
        //写数据
        bos.write("hello\r\n".getBytes());
        bos.write("world\r\n".getBytes());
        //关闭资源
        bos.close();
*/
       //字节缓冲输入流：BufferedInputStream(InputStream in)
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bos.txt"));
/*      int len ;
        while ((len=bis.read())!=-1){
            System.out.print((char) len);
        }
        bis.close();
*/
        //1.一次读取要给字节数组的数据
        byte[] bys = new byte[1024];
        int len ;
        while((len=bis.read(bys))!=-1){
            System.out.println(new String(bys, 0, len));
        }
        bis.close();
    }
}
