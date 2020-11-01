package com.wyclass.test01;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
        练习:通过反射实现如下操作
         Student s = new Student();
         s.method1()
         s.method2("林青霞")
         String ss = s.method3("林青霞",30)
         System.out.println(ss)
         s.function()

 */
public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.wyclass.test.Student");
        Method method1 = c.getMethod("method1");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        method1.invoke(obj);

        Method method2 = c.getMethod("method2", String.class);
        method2.invoke(obj,"林青霞");

        Method method3 = c.getMethod("method3", String.class, int.class);
        Object o = method3.invoke(obj, "林青霞", 30);
        System.out.println(o);

        Method function = c.getDeclaredMethod("function");
        function.setAccessible(true);
        function.invoke(obj);

    }
}
