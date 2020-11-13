package com.wyclass.SystemIn;

import java.io.*;

/*
  将fos.txt文件内容复制到fw.txt中
 */

public class CopyJavaDemo {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("fos.txt"));
//        //根据目的地创建字符输出流对象
//        BufferedWriter bw = new BufferedWriter(new FileWriter("fw.txt"));
//
//        String line;
//        while ((line=br.readLine())!=null){
//           bw.write(line);
//           bw.newLine();
//           bw.flush();
//        }
//        br.close();
//        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("fos.txt"));
        //创建字符打印流  PrintWriter​(OutputStream out, boolean autoFlush) 从现有的OutputStream创建一个新的PrintWriter。
        PrintWriter pw = new PrintWriter(new FileWriter("pw.txt"), true);

        String line;
        while ((line=br.readLine())!=null){
            pw.println(line);
        }
        br.close();
        pw.close();
    }
}
