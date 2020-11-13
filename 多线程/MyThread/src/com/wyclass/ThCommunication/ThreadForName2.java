package com.wyclass.ThCommunication;

import java.util.concurrent.locks.Lock;

//自定义一个测试类 输出2
public class ThreadForName2  extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {


        synchronized (MyLock.obj) {
            System.out.println(Thread.currentThread().getName() + ": 2");
            MyLock.obj.notify();
            try {
               MyLock.obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        }
   }
}
