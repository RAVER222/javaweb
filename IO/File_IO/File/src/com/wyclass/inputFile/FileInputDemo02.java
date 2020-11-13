package com.wyclass.inputFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputDemo02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\loading\\NetProgramming\\text\\java.txt");
        FileOutputStream fos = new FileOutputStream("fos.txt");
        int len;
        byte[] bys= new  byte[1024];

        while((len =fis.read(bys))!=-1){
            fos.write(bys);
        }
        fis.close();
        fos.close();
    }
}
