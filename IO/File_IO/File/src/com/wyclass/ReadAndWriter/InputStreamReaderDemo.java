package com.wyclass.ReadAndWriter;

import java.io.*;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("ows.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("ows1.txt"));

        //int read() 一次读一个字符数据
//        int bys ;
//        while((bys=isr.read())!=-1){
//            System.out.print((char) bys);
//        }
        int len;
        char[] bys = new char[1024];
        while((len=isr.read(bys))!=-1){
            osw.write(bys,0,len);
        }
        isr.close();
        osw.close();
    }
}
