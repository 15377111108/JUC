package com.atguigu;

/**
 * Date:2022/7/22
 * @author:yz
 */
public class Test5 {
    public static void main(String[] args) {
        //创建任务对象
        Demo5 demo5 = new Demo5();
        //创建线程A
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                demo5.printA(i);
            }
        },"线程A").start();
        //创建线程B
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                demo5.printB(i);
            }
        },"线程B").start();
        //创建线程C,不适用lambda表达式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    demo5.printC(i);
                }
            }
        },"线程C");
    }
}
