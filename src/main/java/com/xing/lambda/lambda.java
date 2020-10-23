package com.xing.lambda;

public class lambda {
    public static void main(String[] args) {
        ILove iLove = new Love();
        iLove.love(2);
    }
}

interface ILove{
    void love(int a);
}

class Love implements ILove{

    @Override
    public void love(int a) {
        System.out.println("I love you ==>"+a);
    }
}
