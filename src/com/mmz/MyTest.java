package com.mmz;

/**
 * @Classname MyTest
 * @Description 创建线程池类，提交多个任务，
 * @Date 2020/4/23 0:42
 * @Created by mmz
 */
public class MyTest {
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(2,4,20);
        //提交多个任务
        for(int i = 0;i<10;++i){
            //创建任务对象，提交给线程池
            MyTask myTask = new MyTask(i);
            pool.submit(myTask);
        }
    }
}
