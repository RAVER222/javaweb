package com.wyclass.test02;
   /*
   *     void setDeamon(boolean on) 将此线程标记为守护线程,
   *     当运行的线程都是守护线程时,java虚拟机退出
   *
   *
   * */
public class ThreadDaemonDemo {
    public static void main(String[] args) {
        ThreadDeamon td1 = new ThreadDeamon();
        ThreadDeamon td2= new ThreadDeamon();
        td1.setName("关羽");
        td2.setName("张飞");
        //设置主线程为刘备
        Thread.currentThread().setName("刘备");
        //设置守护线程
        td1.setDaemon(true);
        td2.setDaemon(true);

        td1.start();
        td2.start();

        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
