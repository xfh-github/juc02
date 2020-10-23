package com.xing.state;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("线程vip来了" + i);
        }
    }



    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int j = 1; j <=500; j++) {
            if (j==200){
                Thread.yield();
            }
            System.out.println("main"+j);

        }

    }    }