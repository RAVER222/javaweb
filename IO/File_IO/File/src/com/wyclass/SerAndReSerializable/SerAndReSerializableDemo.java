package com.wyclass.SerAndReSerializable;

    /*
    InvalidClassException: com.wyclass.
    SerAndReSerializable.Student; local class
    incompatible: stream classdesc serialVersionUID = -6942774422310621580, local class serialVersionUID = -3799977971647499704

    当序列化运行时检测到类中的以下问题之一时抛出。
          类的串行版本与从流中读取的类描述符的类型不匹配
          该类包含未知的数据类型
          该类没有可访问的无参数构造函数
     */
import java.io.*;

public class SerAndReSerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
          read();
        //write();
    }

    //序列化
    private static void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));
        Student stu = new Student("林青霞",30);
        oos.writeObject(stu);
        oos.close();
    }

    //反序列化
    private static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream("oos.txt"));
        Object object = ios.readObject();
        Student stu =(Student)object;
        System.out.println(stu.getAge() + "  " + stu.getName());

    }
}
