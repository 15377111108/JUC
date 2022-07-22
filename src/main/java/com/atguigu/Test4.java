package com.atguigu;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */

public class Test4 {
    public static void main(String[] args) {
        //创建任务对象
        Demo4 demo4 = new Demo4();
        //创建线程A,做加一操作
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo4.add();
            }
        },"线程A").start();
        //创建线程B,做减一操作
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo4.decrement();
            }
        },"线程B").start();
    }
}
