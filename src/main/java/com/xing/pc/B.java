package com.xing.pc;

/**
 * 问：请说明一下单例模式的原理
 * 答：通过将构造函数私有化，在类内部创建它的实例对象，通过静态方法将实例对象进行返回
 * 问：单例模式中构造器必须私有化吗？
 * 答：必须私有化，目的是为了防止被其他类进行实例化。
 *
 * 单例模式主要用两种方式：饿汉式和懒汉式。下面我来进行举例
 *
 * 饿汉式：这种方式的优点在进行类加载时就被实例化了，避免了同步问题。缺点是一早就创建了这个实例对象，
 * 如果没有人使用这个实例对象的时候，就会造成内存的浪费。
 */
public class B {
    private static final B b= new B();

    private B(){
    }

    public  static B getInstance(){
        return b;
    }
}

/**
 * 懒汉式:优点线程安全，实现了懒加载，效率快

class Person{
    private static  Person p=null;

    private Person(){

    }

    public static Person getInstance(){
        if (p==null){
            synchronized (Person.class){
                if (p==null){
                    p =new Person();
                }
            }

        }
    }
}
 */