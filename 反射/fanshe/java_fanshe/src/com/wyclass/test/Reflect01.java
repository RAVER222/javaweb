package com.wyclass.test;

public class Reflect01 {
    public static void main(String[] args) throws ClassNotFoundException {
       //1.通过类的class属性获取class对象
        Class<Student> c = Student.class;
        System.out.println(c);

        //
        Class<Student> c1 =Student.class;
        System.out.println(c==c1);

        //通过对象的getClass()方法,返回该对象该属类对应的Class对象
        Student s =new Student();
        Class<? extends Student> c2= s.getClass();
        System.out.println(c2==c);

       //使用Class类中的静态方法forName(String className)
        Class<?> c3 = Class.forName("com.wyclass.test.Student");
        System.out.println(c3==c);

    }
}
