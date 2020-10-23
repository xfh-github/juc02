package com.xing.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程下同步下载图片
public class TestThread2 extends Thread {
    private String url;  //网络图片地址
    private String name; //保存的文件名

    public TestThread2(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public void run(){
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
       TestThread2 t1=new TestThread2("https://img2018.cnblogs.com/blog/1486651/201907/1486651-20190723154946205-1265350885.png","1.png");
       TestThread2 t2=new TestThread2("https://img2018.cnblogs.com/blog/1486651/201907/1486651-20190723154946205-1265350885.png","2.png");
       TestThread2 t3=new TestThread2("https://img2018.cnblogs.com/blog/1486651/201907/1486651-20190723154946205-1265350885.png","3.png");

       t1.start();
       t2.start();
       t3.start();
    }

}
//下载
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常，downloader方法出现问题");
        }
    }
}

















