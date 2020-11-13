package com.wyclass.proctice02;

import java.io.*;

/*
    案例：复制多级文件夹

   分析：
    数据源：E:\\itcast
    目的地：F:\\
    判断数据源是目录还是文件
    是文件：直接复制，用字节流
      是目录：
	   在目的地下创建该目录
	   遍历获取该目录下的所有文件的File数组，得到每一个File对象
	   回到3继续(递归)

   */
public class CopyFoldersDemo {
      public static void main(String[] args) throws IOException {
          //源文件夹创建
          File srcFromFile = new File("D:\\loading\\NetProgramming\\text");
          File  targetFrom = new File("D:\\loading\\NetProgramming\\itcast");
          CopyFolder(srcFromFile,targetFrom);
      }

    private static void CopyFolder(File srcFromFile, File targetFrom) throws IOException {
          //判断是否是目录
          if(srcFromFile.isDirectory()){
              //在目的地文件夹中创建一样的目录
              String srcFileName=srcFromFile.getName();
              System.out.println(srcFileName);
              File newFolder = new File(targetFrom,srcFileName);
              if(!newFolder.exists()){
                  newFolder.mkdir();
              }
              System.out.println(newFolder);
              //获取数据源File下所有文件或者目录的File数组
              File[] listFiles = srcFromFile.listFiles();
              //遍历改File数组,得到每一个File对象
              for (File listFile : listFiles) {
                  System.out.println(listFile);
                  CopyFolder(listFile,newFolder);


              }
          }else{
              //说明是文件
              File newFile = new File(targetFrom,srcFromFile.getName());
              CopyFile(srcFromFile,newFile);
          }
       }

    private static void CopyFile(File srcFromFile, File targetFrom) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFrom));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFromFile));
        byte[] bys = new byte[1024];
        int len;
        while((len=bis.read())!=-1){
            bos.write(bys,0,len);
        }
        bis.close();
        bos.close();
    }
}
