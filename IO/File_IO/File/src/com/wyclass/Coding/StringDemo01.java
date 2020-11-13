package com.wyclass.Coding;
  /*
  byte[] getBytes​() 使用平台的默认字符集将该 String编码为一系列字节，将结果存储到新的字节数组中。
  byte[] getBytes​(Charset charset) 使用给定的charset将该String编码为字节序列，将结果存储到新的字节数组中。
   */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
          String s = "中国";
          byte[] bys = s.getBytes("GBK");
          System.out.println(Arrays.toString(bys));//[-28, -72, -83, -27, -101, -67]  UTF-8
          String ss = new String(bys,"GBK");//[-42, -48, -71, -6]
          System.out.println(ss);

    }
}
