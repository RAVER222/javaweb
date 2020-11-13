package com.wyclass.ThCommunication;

public class TestThreadForName {
    public static void main(String[] args) {
        ThreadForName1 t1 = new ThreadForName1();
        ThreadForName2 t2 = new ThreadForName2();
        t1.start();
        t2.start();

    }
}
