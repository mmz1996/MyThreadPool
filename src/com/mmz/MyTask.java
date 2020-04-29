package com.mmz;

/**
 * @Classname MyTask
 * @Description 任务类，包含任务编号，每一个任务的执行时间为0.2s
 *
 * @Date 2020/4/23 0:21
 * @Created by mmz
 */
public class MyTask  implements Runnable{
    private int id;
    //由于run方法是重写接口中的方法，因此id这个属性的初始化可以利用我们的构造方法。

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("线程:"+name+"即将执行任务:"+id);
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("线程:"+name+"完成了任务:"+id);
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "id=" + id +
                '}';
    }
}
