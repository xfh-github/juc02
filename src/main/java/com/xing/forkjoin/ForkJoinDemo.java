package com.xing.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界值
    private Long temp=10000l;

    public ForkJoinDemo(Long start,Long end){
        this.start=start;
        this.end=end;
    }
    //计算方法

    @Override
    protected Long compute() {
        if ((end-start)<temp){
            Long sum=0l;
            for (Long i = start; i <= end; i++) {
                sum+=i;
            }
           return sum;
        }else { //forkjoin 递归
            long middle=(start+end)/2;  //中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();  //拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1,end);
            task2.fork();  //拆分任务，把任务压入线程队列

            return  task1.join()+task2.join();

        }
    }
}
