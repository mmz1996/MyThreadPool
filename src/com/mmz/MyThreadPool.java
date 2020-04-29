package com.mmz;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname MyThreadPool
 * @Description 自定义的线程池类
 * 成员变量
     * 1.任务队列 集合 需要控制线程安全问题
     * 2.当前线程数量
     * 3.核心线程数
     * 4.最大线程数
     * 5.任务队列长度
 * 成员方法
 * 1.提交方法，将任务添加入集合，需要判断是否超出了任务的总长度
 * 2.执行任务，判断当前线程的数量，决定创建核心线程和非核心线程
 *
 * @Date 2020/4/23 0:30
 * @Created by mmz
 */
public class MyThreadPool {
    //1.任务队列 集合 需要控制线程安全问题
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
    //2.当前线程数量
    private int num;
    //3.核心线程数
    private int corePoolSize;
    //4.最大线程数
    private int maxSize;
    //5.任务队列长度
    private  int workSize;

    //1.提交任务
    public void submit(Runnable runnable){
        //判断当前集合中任务的数量是否超出了最大任务数量
        if(tasks.size()>=workSize){
            System.out.println("任务"+runnable+"被丢弃了");
        }else{
            tasks.add(runnable);
            execTask(runnable);
        }
    }

    //执行任务
    private void execTask(Runnable runnable) {
        //判断当前线程中的线程总数量，是否超出了核心数。
        if(num < corePoolSize){
            new MyWorker("核心线程"+num,tasks).start();
            num++;
        }else if(num < maxSize){
            new MyWorker("非核心线程"+num,tasks).start();
            num++;
        }else{
            System.out.println("任务"+runnable+"被缓存起来了");
        }
    }

    public MyThreadPool(int corePoolSize, int maxSize, int workSize) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.workSize = workSize;
    }
}
