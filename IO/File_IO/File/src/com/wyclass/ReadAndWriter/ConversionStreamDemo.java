package com.wyclass.ReadAndWriter;

import java.io.*;
/*
   InputStreamReader​(InputStream in) 创建一个使用默认字符集的InputStreamReader。
   InputStreamReader​(InputStream in, String charsetName) 创建一个使用命名字符集的InputStreamReader。
*/
public class ConversionStreamDemo {
    public static void main(String[] args) throws IOException {
        /*
        OutputStreamWriter​(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter。
        OutputStreamWriter​(OutputStream out, String charsetName) 创建一个使用命名字符集的OutputStreamWriter。
        */

        /*
        FileOutputStream fos = new FileOutputStream("osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
       */
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("osw.txt"), "GBK");
        osw.write("中国");
        osw.close();
       /*
       InputStreamReader​(InputStream in) 创建一个使用默认字符集的InputStreamReader。
       InputStreamReader​(InputStream in, String charsetName) 创建一个使用命名字符集的InputStreamReader。
      */
        InputStreamReader isr = new InputStreamReader(new FileInputStream("osw.txt"),"GBK");
        //一次读取一个字符数组
        int ch;
        while((ch=isr.read())!=-1){
            System.out.println((char) ch);
        }
        isr.close();
    }
}
