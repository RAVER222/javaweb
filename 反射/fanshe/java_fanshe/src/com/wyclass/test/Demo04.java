package com.wyclass.test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo04 {
    public static void main(String[] args) throws Exception {
        /*
        *   使用反射实现如下的操作:
        *                       private Student(String name)
        * */
        Class<?> c = Class.forName("com.wyclass.test.Student");
        Constructor<?> con = c.getDeclaredConstructor(String.class);

        //void setAccessible​(boolean flag)  将此反射对象的 accessible标志设置为指示的布尔值。
        con.setAccessible(true);
        Object o = con.newInstance("林青霞");
        System.out.println(o);
    }
}
