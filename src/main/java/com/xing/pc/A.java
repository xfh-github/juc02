package com.xing.pc;

public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"B").start();
    }

}
class Data{
    private int number=0;

    public synchronized void increment() throws InterruptedException {
        while (number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notify();
    }
    public synchronized void decrement() throws InterruptedException {
        while (number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notify();
    }
}
