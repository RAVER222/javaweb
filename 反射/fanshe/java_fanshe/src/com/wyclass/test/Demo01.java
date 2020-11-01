package com.wyclass.test;

/*
*    classloader 中的两个方法
*    getParent​() 返回父类加载器进行委派。
*    static ClassLoader getSystemClassLoader​() 返回用于委派的系统类加载器。
*/

public class Demo01 {
    public static void main(String[] args) {
        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println(c); // Application ClassLoader

        ClassLoader parent = c.getParent();
        System.out.println(parent); //Extension Classloader

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);// Bootstrap ClassLoader

    }
}
