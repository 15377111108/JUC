package com.atguigu;

/**
 * Date:2022/7/22
 *
 * @author:yz
 */
/*synchronized线程之间的通信*/
public class Demo3 {
    /*监控的变量*/
    private int num = 0;

    public synchronized void add(){
        //如果此时num不为0,则等待
            try {
                if (num!=0){
                    this.wait();
                }
                num++;
                System.out.println(Thread.currentThread().getName()+"线程执行了+1操作,此时num为"+num);
                //唤醒其他的线程
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public synchronized void decrement(){

            try {
                if (num!=1){
                    this.wait();
                }
                num--;
                System.out.println(Thread.currentThread().getName()+"线程执行了-1操作,此时num为"+num);
                //唤醒其他线程
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
