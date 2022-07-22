package com.atguigu;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */
public class Test1 {
    public static void main(String[] args) {
        //构建一个卖票的对象
        SaleTicket saleTicket = new SaleTicket();
        //启动线程A去买票
        new Thread(()->{
            for (int i = 0; i <30 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                saleTicket.save();
            }
        },"线程A").start();
        //启动线程B去买票
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                saleTicket.save();
            }
        },"线程B").start();
    }
}
