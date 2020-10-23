package com.xing.demo01;

import com.xing.pc.B;

//龟兔赛跑
public class Race implements Runnable {

    //胜利者
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子")&&i%10==1){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            boolean flag=gameover(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");

        }
    }
    //判断是否完成了比赛
    private boolean gameover(int steps){
        if(winner !=null){
            return true;
        }
        {
            if(steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("赢家是："+winner);
                return true;
            }
        }return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
       new Thread(race,"兔子").start();
       new Thread(race,"乌龟").start();
    }

}
