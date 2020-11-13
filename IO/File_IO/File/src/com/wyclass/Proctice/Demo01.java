package com.wyclass.Proctice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //有成绩从高到低
                int sum = s2.sum()-s1.sum();
                int sum2 =sum ==0 ? s1.getChinese()-s2.getChinese() : sum;
                int sum3 =sum2 ==0? s1.getEnglish()-s2.getEnglish(): sum2;
                int sum4 = sum3==0 ? s1.getMath()-s2.getMath() :sum3;
                return sum4;
            }
        });
        //键盘录入学生数据
        for (int i = 0; i <5 ; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("录入第"+(i+1)+"个学生的信息");
            System.out.println("姓名:");
            String name = sc.nextLine();
            System.out.println("语文成绩:");
            int chinese = sc.nextInt();
            System.out.println("数学成绩:");
            int math = sc.nextInt();
            System.out.println("英语成绩:");
            int english = sc.nextInt();

            Student stu = new Student();
            stu.setName(name);
            stu.setChinese(chinese);
            stu.setMath(math);
            stu.setEnglish(english);
            ts.add(stu);
        }

        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
        //遍历集合,得到每一个学生对象
        //格式,姓名,语文成绩,数学成绩,英语成绩
        for (Student t : ts) {
            StringBuffer sb = new StringBuffer();
            sb.append(t.getName()+" ").append(t.getChinese()+" ").append(t.getChinese()+" ").append(t.getMath()+" ").append(t.getEnglish()+" ").append(t.sum());

         //调用字符缓冲输出流对象的方法写数据
          bw.write(sb.toString());
          bw.newLine();
          bw.flush();
        }
        //释放资源
        bw.close();
    }
}
