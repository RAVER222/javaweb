package com.wyclass.ThCommunication;

//自定义一个线程类  输出1
public class ThreadForName1 extends  Thread{
  /*
    wait:让当前调用了wait的对象的所在线程堵塞，前提是当前线程获得了同步锁
    notify：通知调用了wait的对象继续执行，不堵塞，前提是调用了notify的对象已经出了synchronized代码块，释放了锁，才能通知成功

    wait和notify的调用者必须是同一个对象，只有这么才能通信
    wait和notify必须执行在synchronized代码块中，必须要加锁，不然会抛IllegalMonitorStateException异常
    wait和notify是每个对象都有的方法，是Object的方法，因为每个对象都有锁，锁是对象的基础，
    wait和notify必须用while循环，因为这个可以往复判断条件
   */

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (MyLock.obj) {
                System.out.println(Thread.currentThread().getName() + " :1");
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
