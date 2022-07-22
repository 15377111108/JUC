package com.atguigu;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */
//synchronized线程之间的通信问题
public class Test3 {
    public static void main(String[] args) {
        //创建任务对象
        Demo3 demo3 = new Demo3();
        //加减交替,保证常量不变
        //执行+操作
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo3.add();
            }
        },"线程A").start();
        //执行-操作
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo3.decrement();
            }
        },"线程B").start();
    }
}
