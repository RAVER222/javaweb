package com.wyclass.Proctice01;
import java.io.*;

/*
需求：把“D:\loading\NetProgramming\text”这个文件夹复制到模块目录下
   思路：
创建数据源目录File对象，路径是D:\loading\NetProgramming\text
获取数据源目录File对象的名称
创建目的地目录File对象，路径由(模块名+第2步获取的名称)组成
判断第3步创建的File是否存在，如果不存在，就创建
获取数据源目录下所有文件的File数组
遍历File数组，得到每一个File对象，该File对象，其实就是数据源文件
获取数据源文件File对象的名称
创建目的地文件File对象，路径由(目的地目录+第7步获取的名称)组成
复制文件
由于不清楚数据源目录下的文件都是什么类型的，所以采用字节流复制文件
采用参数为File的构造方法
*/

public class CopyFolderDemo {
    public static void main(String[] args) throws IOException {
        //创建一个数据源文件
        File srcFolder = new File("D:\\loading\\NetProgramming\\text");
        //获取数据源 File对象的名称(text)
        String srcFolderName =srcFolder.getName();

        //创建目的地目录File对象,路径名就是模块名+itcast组成()
        File destFolder = new File(srcFolderName);

        //判断目的地目录对应的File时候存在,如果不存在,就创建
        if(!destFolder.exists()){
            destFolder.mkdir();
        }
        //获取数据源目录下所有文件的File数组
        File[] listFiles = srcFolder.listFiles();
        //遍历File数组,得到每一个File对象,该File对象,其实就是数据源文件

        //遍历File数组,得到每一个File对象,该File兑现,其实就是数据源文件
        for (File srcFile : listFiles){
            //获取数据源文件FIle对象的名称
            String name = srcFile.getName();

            System.out.println(name);
            //创建源文件
            File srcFromFile = new File(srcFolder,name);
            //创建目标文件名
            File destFile = new File(destFolder,name);

            copyFile(srcFromFile,destFile);
        }
    }

    private static void copyFile(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bys = new byte[1024];
        int len ;
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
}