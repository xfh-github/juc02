package com.xing.lock8;

import java.util.concurrent.TimeUnit;

public class  Test {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->{
            phone.sendmassage();
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
          phone.call();
      }).start();
}}
class Phone{
    public synchronized void sendmassage(){
        System.out.println("发信息");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
}
