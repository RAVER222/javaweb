package com.wyclass.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo03 {
    public static void main(String[] args) throws Exception{
        /*
         *
         *   使用反射实现如下的操作:
         *                    Student s = new Student("林青霞",30,"西安");
         * */

        Class<?> c = Class.forName("com.wyclass.test.Student");
        Constructor<?> constructor = c.getConstructor(String.class,int.class,String.class);
        //基本数据类型也可以通过class得到对应的class类型
        System.out.println(constructor);
       Object o = constructor.newInstance("林青霞", 30, "西安");
        System.out.println(o);

    }
}
