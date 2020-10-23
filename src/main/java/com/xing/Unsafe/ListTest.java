package com.xing.Unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        //并发下的Arraylist不安全的
        //解决方案：
        //1.List<String> list = new Vector<>();
        //2.List<String> list = Collections.synchronizedList(new ArrayList<>());


        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
    }
}
