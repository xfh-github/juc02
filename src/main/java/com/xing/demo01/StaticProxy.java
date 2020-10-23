package com.xing.demo01;

public class StaticProxy {
    public static void main(String[] args) {
        you 简约=new you();
        WeddingCompany weddingCompany = new WeddingCompany(简约);
        weddingCompany.HappyMarry();
    }
}

class you implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("谁要要结婚了");
    }
}
class WeddingCompany implements Marry{

    private Marry target;
    public WeddingCompany(Marry target){
        this.target=target;
    }
    @Override
    public void HappyMarry() {
    before();
    this.target.HappyMarry();
    after();
    }

    private void before() {
        System.out.println("结婚之前：布置现场");
    }
    private void after(){
        System.out.println("结婚之后 ：收取尾款");

    }
}