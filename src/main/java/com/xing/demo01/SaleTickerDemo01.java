package com.xing.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTickerDemo01 {
    public static void main(String[] args) {
        //并发：多线程操作同一资源类，吧资源类丢入线程中去
        Ticket2 ticket = new Ticket2();
        new Thread(()->{for (int i=1;i<40;i++) ticket.sale();},"A").start();
        new Thread(()->{for (int i=1;i<40;i++) ticket.sale();},"B").start();
        new Thread(()->{for (int i=1;i<40;i++) ticket.sale();},"C").start();

    }

}
//资源类 oop
class Ticket2{
    //属性，方法
    private  int number=30;

   Lock lock=new ReentrantLock();

    //买票的方式
    public void sale(){
lock.lock();
        try {
            //业务代码

            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
