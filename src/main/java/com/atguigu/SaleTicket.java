package com.atguigu;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */
/*卖票案例*/
public class SaleTicket {
   /*定义票数*/
    private int ticket = 30;

    /**
     * 卖票方法
     */
    public synchronized void save(){
        if (ticket>0){
            ticket--;
            //Thread.currentThread().getName():当前前程的名字
            System.out.println(Thread.currentThread().getName()+"线程卖出了一张票,还剩下"+ticket+"张票");
        }
    }

}
