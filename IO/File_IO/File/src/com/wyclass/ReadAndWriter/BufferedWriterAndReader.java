package com.wyclass.ReadAndWriter;

import java.io.*;

//BufferedWriter​(Writer out) 创建使用默认大小的输出缓冲区的缓冲字符输出流。

public class BufferedWriterAndReader {
    public static void main(String[] args) throws IOException {
//        FileWriter fw = new FileWriter("fos.txt");
//        BufferedWriter bw  = new BufferedWriter(fw);
//        bw.write("hello,java\r\n");
//        bw.write("从入门到精通....\r\n");
//        bw.close();

//        BufferedReader br = new BufferedReader(new FileReader("fos.txt"));
//        int len ;
//        while((len=br.read())!=-1){
//            System.out.print((char) len);
//        }

        BufferedReader br = new BufferedReader(new FileReader("fos.txt"));
        int len ;
        char[] bys = new char[1024];
        while ((len=br.read(bys))!=-1){
            System.out.println(new String(bys, 0, len));
        }
        br.close();
    }
}
