package com.wyclass.test01;

public class ThreadPrivrityDemo {
    public static void main(String[] args) {
        ThreadPriority tp1= new ThreadPriority();
        ThreadPriority tp2= new ThreadPriority();
        ThreadPriority tp3= new ThreadPriority();

        tp1.setName("高铁");
        tp2.setName("飞机");
        tp3.setName("汽车");

        tp1.start();
        tp2.start();
        tp3.start();

        tp1.setPriority(10);
        tp2.setPriority(5);
        tp3.setPriority(2);
    }
}
