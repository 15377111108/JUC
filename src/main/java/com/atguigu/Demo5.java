package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */
//A线程打印5次A，B线程打印10次B，C线程打印15次C,按照此顺序循环10轮**==
public class Demo5 {
    //当num=0打印a5次,当num=1打印b10次,当num=2时打印c15次
    private int num = 0;

    //声明锁
    private Lock lock = new ReentrantLock();

    //声明钥匙A
    private Condition conditionA = lock.newCondition();

    //声明钥匙B
    private Condition conditionB = lock.newCondition();

    //声明钥匙C
    private Condition conditionC = lock.newCondition();

    /**
     * 打印5次A
     */
    public void printA(int j) {
        //上锁
        lock.lock();
        try {
            if (num != 0) {
                //等待
                conditionA.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"线程A开始第"+j+"轮打印"+"A");
            }
            //开始打印B
            num=1;
            //唤醒B
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关锁
            lock.unlock();
        }
    }
    /**
     * 打印10次B
     */
    public void printB(int j){
        //上锁
        lock.lock();
        try {
            if (num!=1){
                //等待
                conditionB.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"线程B开始第"+j+"轮打印"+"B");
            }
            //开始打印C
            num=2;
            //唤醒C线程
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关锁
            lock.unlock();
        }
    }
    /**
     * 打印15次C
     */
    public void printC(int j){
        //开锁
        lock.lock();
        try {
            if (num != 2) {
                //等待
                conditionC.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "线程C开始第" + j + "轮打印"+"C");
            }
            //开始打印A
            num=0;
            //唤醒A线程
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关锁
            lock.unlock();
        }
    }
}
