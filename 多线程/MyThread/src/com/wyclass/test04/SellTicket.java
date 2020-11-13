package com.wyclass.test04;

public class SellTicket  implements Runnable{
    //private int ticket = 100;
    private static int ticket = 100;
    private Object obj = new Object();
    private int x=0;
    @Override
    public void run() {
        while(true) {
            if (x%2==0) {
//                synchronized (obj) {
                synchronized (SellTicket.class) {
                    if (ticket > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("正在出售" + ticket-- + "张票");
                    }
                }
            }
            else{
                sellTicket();
            }
            x++;
        }
    }

//    private void sellTicket() {
//        synchronized (obj) {
//            if (ticket > 0) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("正在出售" + ticket-- + "张票");
//            }
//        }
//    }

    private static synchronized void sellTicket() {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("正在出售" + ticket-- + "张票");
            }
        }
}
