package com.xing.state;

public class Yield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行了");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");

    }
}