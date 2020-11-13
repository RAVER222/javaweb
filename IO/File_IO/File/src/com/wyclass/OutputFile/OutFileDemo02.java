package com.wyclass.OutputFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
   /*
     字节流数据的两个小问题:
              1.字节流写数据如何实现换行呢？
               window :\r\n
               linux:\n
               mac:\r
              2.字节流写数据如何实现追加写入呢？

              public FileOutputStream​(String name,
                        boolean append)
                 throws FileNotFoundException创建文件输出流以指定的名称写入文件。 如果第二个参数为true ，
                 则字节将写入文件的末尾而不是开头。 将创建一个新的FileDescriptor对象来表示此文件连接。
    */
public class OutFileDemo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos= new FileOutputStream("fos2.txt");

        //写数据
        for (int i = 0; i <10 ; i++) {
            fos.write("hello".getBytes());
            fos.write("\r\n".getBytes());

        }

        //释放资源
        fos.close();
    }
}