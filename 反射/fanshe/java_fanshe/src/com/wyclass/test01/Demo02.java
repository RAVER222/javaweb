package com.wyclass.test01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo02 {
        /*
             通过反射实现如下步骤:
             Student s = new Student();
             s.student = "林青霞";
             s.age =30;
             s.address ="西安";
             System.out.println(s);
         */

        public static void main(String[] args) throws Exception{
                Class<?> c = Class.forName("com.wyclass.test.Student");
                Constructor<?> constructor = c.getConstructor();
                Object obj = constructor.newInstance();
                System.out.println(obj);

                Field nameField = c.getDeclaredField("name");
                nameField.setAccessible(true);
                nameField.set(obj,"林青霞");
                Field age = c.getDeclaredField("age");
                age.setAccessible(true);
                age.set(obj,30);
                Field address = c.getField("address");
                address.set(obj,"西安");
                System.out.println(obj);
        }
}
