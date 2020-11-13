package com.wyclass.SystemIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
  public static final InputStream in“标准”输入流。 该流已经打开，准备提供输入数据。
  通常，该流对应于键盘输入或由主机环境或用户指定的另一个输入源。
 */
public class SystemInDemo {
    public static void main(String[] args) throws IOException {
//        InputStream in = System.in;
//        int by;
//        while ((by=in.read())!=-1){
//            System.out.println((char) by);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println("输入的字符串是"+s);
        int i = Integer.parseInt(br.readLine());
        System.out.println(i);
    }
}
