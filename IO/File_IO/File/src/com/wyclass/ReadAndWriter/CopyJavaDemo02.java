package com.wyclass.ReadAndWriter;



import java.io.*;

public class CopyJavaDemo02 {
    public static void main(String[] args) throws IOException {
        //根据数据源常见字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("fos.txt"));
        //根据目的地创建字节缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("fos1.txt"));
        String line;
        while ((line =(br.readLine()))!=null)
        {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
