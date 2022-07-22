package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */
/*Lock线程之间的通信*/
public class Demo4 {
    //监控的对象
    private int num = 0;

    //声明锁
    private Lock lock = new ReentrantLock();

    //声明钥匙
    private Condition condition = lock.newCondition();

    /**
     * 声明加1操作
     */
    public void add() {
        //不为0则等待
        lock.lock();
        try {
            if (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "线程执行了+1操作,此时num为" + num);
            //唤醒其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //必须关锁,有几把关几把
            lock.unlock();
        }
    }

    public void decrement() {
        //上锁
        lock.lock();
        //等待
        try {
            if (num != 1) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "线程执行了-1操作,此时num为" + num);
            //唤醒其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //关锁
            lock.unlock();
        }
    }
}
