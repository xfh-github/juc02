package com.xing.demo01;

public class TestThread3 implements Runnable{
    @Override
    //run方法线程体
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码——————");
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程---");

        }
    }
}
