package com.xing.lambda;

public class TestLambda23 {
    public static void main(String[] args) {
        Ilove ilove =(int a)-> { System.out.println("I love you-->"+a); };
ilove.love(2);
    }

}

interface Ilove{
    void love(int a);
}