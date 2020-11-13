package com.wyclass.ReadAndWriter;

import java.io.*;

public class BufferCopyJavaDemo01 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("ows1.txt"));
        BufferedReader br = new BufferedReader(new FileReader("ows.txt"));
//
//        char[] chs = new char[1024];
//        int len ;
//        while((len=br.read(chs))!=-1){
//            bw.write(chs,0,len);
//        }
      int len;
      while ((len=br.read())!=-1){
          bw.write(len);
      }
        bw.close();
        br.close();
    }
}
