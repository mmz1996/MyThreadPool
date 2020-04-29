package com.mmz;

import java.util.List;

/**
 * @Classname MyWorker
 * @Description 编写一个线程类，需要继承Thread类，设计一个属性，用于保存线程的名字，设计一个集合，用于保存所有的任务
 * @Date 2020/4/23 0:26
 * @Created by mmz
 */
public class MyWorker extends Thread{
    private String name;//保存线程的名字

    private List<Runnable> tasks;

    public MyWorker(String name, List<Runnable> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run(){
        //判断集合是否有任务
        while(tasks.size()>0){
            Runnable runnable = tasks.remove(0);
            runnable.run();
        }

    }
}
