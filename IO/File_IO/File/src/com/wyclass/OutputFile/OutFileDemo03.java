package com.wyclass.OutputFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutFileDemo03 {
    public static void main(String[] args) throws FileNotFoundException {
        //加入finally来实现释放资源
        FileOutputStream  fos = null;
        try{
            fos = new FileOutputStream("Z:\\fos.txt");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
//            if (fos!=null){
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
