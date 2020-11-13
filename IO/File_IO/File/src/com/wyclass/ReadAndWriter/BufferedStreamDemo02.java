package com.wyclass.ReadAndWriter;

import java.io.*;

public class BufferedStreamDemo02 {
    public static void main(String[] args) throws IOException {
        /*
        void newLine​() 写一行行分隔符。 不包含任何的终止符号
        String readLine​() 读一行文字。
         */
        BufferedReader br = new BufferedReader(new FileReader("bos.txt"));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
       br.close();
    }
}
