package com.atguigu;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */

/**
 * 隐式可重入锁案例
 * 一个进程对锁资源加锁之后,下次只有自己能用
 */
public class SaleTicket2 {
    //票数
    private int ticket = 30;
    //获取锁的次数
    private int count = 0;

    public synchronized void sale(){
       if (ticket>0){
           ticket--;
           System.out.println(Thread.currentThread().getName()+"线程卖出了一张票,还剩下"+ticket+"张票");
           //计算获取锁的次数
           count++;
           System.out.println(Thread.currentThread().getName()+"线程获取锁"+count+"次");
           //继续执行这个方法,再次上锁
           sale();
       }
    }
}
