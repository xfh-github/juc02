package com.xing.state;

public class TestSleep implements Runnable{

    private int ticketNums=10;
    @Override
    public void run() {
        while (true){
            if(ticketNums<=0){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep,"A").start();
        new Thread(testSleep,"B").start();
    }
}
