package com.wyclass.test01;

import com.wyclass.test.Student;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo01 {
    public static void main(String[] args) throws Exception{
        Class<?> c = Class.forName("com.wyclass.test.Student");
        /*
          Field[] getFields​() 返回一个包含 Field对象的数组
          Field对象反映由该 Class对象表示的类或接口的所有可访问的公共字段

          Field[] getDeclaredFields​() 返回一个 Field对象的数组，
          反映了由该 Class对象表示的类或接口声明的所有字段。
        */
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("------------------------------------------");
       /*
        Field getField​(String name) 返回一个 Field对象，
         该对象反映由该 Class对象表示的类或接口的指定公共成员字段。

        Field getDeclaredField​(String name) 返回一个 Field对象，
       该对象反映由该 Class对象表示的类或接口的指定声明字段。
        */

        /*
        Student student = new Student();
        student.address="西安";
        System.out.println(address);
        */
        Field address = c.getField("address");
        Constructor<?> con = c.getConstructor();
        System.out.println(con);
        Object obj = con.newInstance();
        System.out.println(obj);
        /*
         Field提供有关类或接口的单个字段的信息和动态访问
         void set​(Object obj, Object value) 将指定的对象参数中由此 Field对象表示的字段设置为指定的新值
        */
        address.set(obj,"西安"); //给obj的成员变量addressField赋值为西安
        System.out.println(obj);
    }
}
