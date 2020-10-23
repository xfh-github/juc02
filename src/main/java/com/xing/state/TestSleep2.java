package com.xing.state;

public class TestSleep2 {
    public static void main(String[] args) {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

public static void  tenDown() throws InterruptedException {
    int num=10;
    while(true){
        Thread.sleep(500);
        System.out.println(num--);
        if(num<=0){
            break;
        }
    }
}}