package com.xing.demo01;

public class TestThread4 implements Runnable {
    private int ticketnum=10;

    @Override
    public void run() {
       while(true){
           if(ticketnum<=0){
               break;
           }

           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+"====>卖出了多少票："+ticketnum--);
       }
    }

    public static void main(String[] args) {
        TestThread4 t4 = new TestThread4();

        new Thread(t4,"小明").start();
        new Thread(t4,"老师").start();
        new Thread(t4,"小赵").start();
    }
}
