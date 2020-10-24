package com.xing.Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

//四组API
class Testa {
    public static void main(String[] args)throws InterruptedException {
       // test1();
        test2();
        //test4();

    }
    public static void test4() throws InterruptedException{

        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("e");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
      //  blockingQueue.offer("d",2, TimeUnit.SECONDS);
        System.out.println("=========");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //blockingQueue.offer("d",2, TimeUnit.SECONDS);

    }
    public static void test1(){
        //队列的大小
     ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
     System.out.println(blockingQueue.add("a"));
     System.out.println(blockingQueue.add("b"));
     System.out.println(blockingQueue.add("c"));

     System.out.println("=========");
     System.out.println(blockingQueue.remove());
     System.out.println(blockingQueue.remove());
     System.out.println(blockingQueue.remove());
   //  System.out.println(blockingQueue.remove());

 }
    public static void test2(){
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //System.out.println(blockingQueue.offer("d")); false 不抛出异常，返回false
        System.out.println("=========");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }
}
