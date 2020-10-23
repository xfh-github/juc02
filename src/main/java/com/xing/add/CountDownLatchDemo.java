package com.xing.add;

import java.util.concurrent.CountDownLatch;
//减法计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown(); //数量减一
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("close door");
    }
}
