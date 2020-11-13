package com.wyclass.ReadAndWriter;
  /*
   需求:把ArrayList集合中的学生数据写入到文本文件.要求:每个学生对象的数据作为文件中的
   一行数据格式:学号,姓名,年龄, 居住地    聚类:itheima001,林青霞,30,西安

  1.定义学生类
  2.创建ArrayList集合
  3.创建学生对象
  4.把学生对象添加到集合中
  5.创建字符缓冲输出流对象
  6.遍历卷积核,得到每一个学生对象
  7.把学生对象的数据拼接成指定格式的字符串
  8.调用字符缓冲输出流对象的方法写数据
  9.释放资源
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ArrayListToFileDemo {
      public static void main(String[] args) throws IOException {
      Student s1 = new Student("itheima001","林青霞",30);
      Student s2 = new Student("itheima002","张曼玉",25);
      Student s3 = new Student("itheima003","王祖贤",21);

      ArrayList<Student> array = new ArrayList<Student>();
      array.add(s1);
      array.add(s2);
      array.add(s3);

      //创建字符缓冲输出流对象
      BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));

      //遍历集合
          for (Student s : array) {
              StringBuffer sb = new StringBuffer();
              sb.append(s.getId()).append(",").append(s.getName()).append(",").append(s.getAge());

              //调用字符缓冲输出流对象的方法写数据
              bw.write(sb.toString());
              bw.newLine();
              bw.flush();
          }
          //释放资源
          bw.close();
      }
}
