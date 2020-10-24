package com.xing.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//1.第一个拒绝策略：new ThreadPoolExecutor.AbortPolicy() 银行满了，还有人进来，不处理这个人，抛出异常
//2.第二个拒绝策略： new ThreadPoolExecutor.CallerRunsPolicy()  哪来的去哪里
//3.第三个拒绝策略：new ThreadPoolExecutor.DiscardPolicy() 队列满了，丢掉任务不会抛出异常
//4.第四个拒绝策略： new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试和最早的竞争，也不会抛出异常

public class Demo02 {
    //自定义线程池！工作ThreadPoolExecutor
    public static void main(String[] args) {
        System.out.println("======"+Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()//银行满了，再来人也不处理了
                 );
        try {
            for (int i = 1; i <= 5; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ：ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
