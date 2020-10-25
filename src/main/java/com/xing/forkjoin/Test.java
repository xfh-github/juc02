package com.xing.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    //test1();//8904
      //  test2();//7398
        test3();//666
    }
    //普通程序员
    public  static void test1(){
        Long sum=0L;
        long start=System.currentTimeMillis();
        for (Long i = 1l; i < 10_0000_0000; i++) {
            sum+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println("sum="+sum+"时间"+(end-start));
    }

    //会使用Forkjoin
    public  static void test2() throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();

        long end= System.currentTimeMillis();
        System.out.println("sum="+sum+"时间"+(end-start));
    }

    //Stream并行流
    public  static void test3(){
        long start=System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end=System.currentTimeMillis();
        System.out.println("sum="+"时间"+(end-start));
    }














}
