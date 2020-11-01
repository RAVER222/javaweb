package com.wyclass.test01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        Class<?> c = Class.forName("com.wyclass.test.Student");
        /*
         getMethods​() 返回一个包含 方法对象的数组， 方法对象反映由
        该 Class对象表示的类或接口的所有公共方法，包括由类或接口声明的对象以及从超类和超级接口继承的类

        getDeclaredMethods​() 返回一个包含方法对象的数组， 方法对象反映由 Class对象表示的类或接口的所有声明方法，
        包括public，protected，default（package）访问和私有方法，但不包括继承方法。
         */
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-------------------------");

        Method method1 = c.getMethod("method1");
        System.out.println(method1);
        //获取无参构造方法创建对象
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        System.out.println(obj);
        /*
        Object invoke​(Object obj, Object... args) 在具有指定参数的指定对象上调用此 方法对象表示的基础方法。
        */
        method1.invoke(obj);

    }
}
