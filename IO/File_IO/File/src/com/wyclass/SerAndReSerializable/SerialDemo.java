package com.wyclass.SerAndReSerializable;
import java.io.*;
/*
对象序列化:就是将对象保存到磁盘中，或者在网络中传输对象
这种机制就是使用一个字节序列表示一个对象，该字节序列包含：对象的类型、对象的数据和对象中存储的属性等信息
字节序列写到文件之后，相当于文件中持久保存了一个对象的信息

反之，该字节序列还可以从文件中读取回来，重构对象，对它进行反序列化

      Serializable:不实现此接口的类将不会使任何状态序列化或反序列化。
      可序列化类的所有子类型都是可序列化的。 序列化接口没有方法或字段，仅用于标识可串行化的语义。

     对象序列化流：ObjectOutputStream
 */
public class SerialDemo {
    public static void main(String[] args) throws IOException {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));
         Student stu =new Student("林青霞",30);
         oos.writeObject(stu);
         oos.close();
    }
}
