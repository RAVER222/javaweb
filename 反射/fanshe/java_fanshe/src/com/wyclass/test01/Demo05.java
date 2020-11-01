package com.wyclass.test01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
 /*
    有一个ArrayList<Integer>集合,现在想在这个集合中添加一个字符串
  */
public class Demo05 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建集合
        ArrayList<Integer> array = new ArrayList<Integer>();
//        array.add(10);
//        array.add(20);
//        array.add(30);
        Class<? extends ArrayList> ac = array.getClass();
        Method add = ac.getMethod("add", Object.class);
        add.invoke(array, "hello");
        add.invoke(array, 20);
        add.invoke(array, 30);
        System.out.println(array);



    }
}
