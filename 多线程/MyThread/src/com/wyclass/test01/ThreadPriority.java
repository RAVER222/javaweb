package com.wyclass.test01;

public class ThreadPriority extends Thread{
    public void run(){
        for (int i = 0; i <100 ; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
