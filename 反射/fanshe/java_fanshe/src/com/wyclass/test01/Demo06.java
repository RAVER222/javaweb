package com.wyclass.test01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
     通过配置文件运行类中的方法
   */
public class Demo06 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //加载数据
        Properties  pro = new Properties();
        FileReader fr= new FileReader("class.txt");
        pro.load(fr);
        fr.close();

        String className = pro.getProperty("className");
        String methodName  = pro.getProperty("methodName");
        //通过反射实现
        Class<?> con = Class.forName(className);
        Object obj = con.newInstance();

        Method m = con.getMethod(methodName);
        m.invoke(obj);

    }
}
