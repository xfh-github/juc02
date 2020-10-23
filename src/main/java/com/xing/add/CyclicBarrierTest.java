package com.xing.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    //聚集7颗龙珠召唤神龙
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(90,()->{
            System.out.println("召唤神龙成功！");
        });

        for (int i = 0; i <= 7; i++) {
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
