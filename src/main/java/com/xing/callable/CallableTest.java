package com.xing.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       // new Thread().start(); //怎么启动线程
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        Integer o = (Integer) futureTask.get();
        System.out.println(o);

    }
}
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() {
        System.out.println("call()");
        return 1024;
    }
}