package com.wyclass.test05;

/*
 需求:有100张票,有3个窗口,设计一个程序模拟该电影票买票
  思路:



 */

public class SellTtickerDemo {
    public static void main(String[] args) {
        SellTicket st = new SellTicket();
        Thread t1 = new Thread(st,"第一售票窗口");
        Thread t2 = new Thread(st,"第二售票窗口");
        t1.start();
        t2.start();
    }
}
