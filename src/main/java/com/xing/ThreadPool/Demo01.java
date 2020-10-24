package com.xing.ThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// Executors 工具类，3大方法
public class Demo01 {
    public static void main(String[] args) {
        //ExecutorService threadpool = Executors.newSingleThreadExecutor(); //单个线程
       // ExecutorService threadPool = Executors.newFixedThreadPool(50); //创建一个固定的线程池的大小
        ExecutorService threadPool = Executors.newCachedThreadPool(); //可伸缩的，遇强则强，遇弱则弱
        try {
            for (int i = 0; i < 1000; i++) {

                //使用了线程池之后，使用线程池来创建线程
                threadPool.execute(()->{

                    System.out.println(Thread.currentThread().getName()+":ok");
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
