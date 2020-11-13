package com.wyclass.Properties;

import java.io.*;
import java.util.Properties;

/*
   void store​(Writer writer, String comments) 将此属性列表（键和元素对）
   写入此 Properties表中，以适合使用 load(Reader)方法的格式输出到输出字符流。
    void load​(Reader reader) 以简单的线性格式从输入字符流读取属性列表（关键字和元素对）。
 */
public class PropertiesDemo03 {
    public static void main(String[] args) throws IOException {
        //把集合中的数据保存到文件
        //myStore();
        //把文件中的数据加载到集合
        myload();
    }

    private static void myload() throws IOException {
        Properties prop = new Properties();
        //void load​(Reader reader) 以简单的线性格式从输入字符流读取属性列表（关键字和元素对）。
        FileReader fileReader = new FileReader("fw.txt");
        prop.load(fileReader);
        fileReader.close();
        System.out.println(prop);
    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();
        FileWriter fw = new FileWriter("fw.txt");
        prop.put("itheima001","林青霞");
        prop.put("itheima002","张曼玉");
        prop.put("itheima003","王祖贤");
        prop.store(fw,null);
        fw.close();
    }
}
