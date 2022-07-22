package com.atguigu;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */

/**
 * 测试隐式可重入锁案例
 */
public class Test2 {
    public static void main(String[] args) {
        //创建买票的对象
        SaleTicket2 saleTicket2 = new SaleTicket2();
        //启动两个线程去买票
        new Thread(()->{
            saleTicket2.sale();
        },"线程A").start();
        new Thread(()->{
            saleTicket2.sale();
        },"线程B").start();
    }
}
