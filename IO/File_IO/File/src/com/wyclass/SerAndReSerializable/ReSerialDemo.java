package com.wyclass.SerAndReSerializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
对象反序列化流： ObjectInputStream
ObjectInputStream反序列化先前使用ObjectOutputStream编写的原始数据和对象

构造方法：
ObjectInputStream​(InputStream in)：创建从指定的InputStream读取的ObjectInputStream

反序列化对象的方法：
Object readObject​()：从ObjectInputStream读取一个对象
 */
public class ReSerialDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("oos.txt"));
        Object object = ois.readObject();
        Student stu = (Student)object;
        System.out.println(stu);
    }
}
