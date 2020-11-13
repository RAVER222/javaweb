package com.wyclass.test03;

public class SellTicket  implements Runnable{
    private int ticket = 100;
    private Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("正在出售"+ticket-- + "张票");
                }
            }
        }
    }
}
