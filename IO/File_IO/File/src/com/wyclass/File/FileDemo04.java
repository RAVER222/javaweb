package com.wyclass.File;
import java.io.File;
/*
    需求:给定一个路径(D:\loading\NetProgramming\text),请通过递归完成遍历改目录下的所有内容,
    并把所有文件的绝对路径输出在控制台
       思路:
         1.根据给定的路径 创建一个File对象
         2.定义一个方法,用于获取给定目录下的所有内容,参数为第一步1创建的File对象
         3.获取给定的File目录下所有的文件或者目录的File数组
         4.遍历改File数组,得到每个File对象
         5.判断该File对象是否是目录
             是,递归调用
             不是,获取绝对路径输出在控制台
         6.调用方法

*/
public class FileDemo04 {
    public static void main(String[] args) {
        File f1 =new File("D:\\loading\\NetProgramming\\text");
        getAllFilePath(f1);
    }
    //定义一个方法,用于获取给定目录下的所有内容,参数为第一步创建的File对象
    public static void getAllFilePath(File file){
        //获取给定的File目录下的文件或者目录的File数组
        File[] f2 =file.listFiles();
        //遍历该File数组,得到每一个File对象
        if(f2!=null){
            for (File file1 : f2) {
                //判断该File对象时是否是目录
                if(file1.isDirectory()){
                    getAllFilePath(file1);
                }else{
                    //不是,获取绝对路径输出该控制台
                    System.out.println(file1.getAbsolutePath());
                }
            }
        }
    }
}
