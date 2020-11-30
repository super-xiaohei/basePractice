package practice;

import java.io.ObjectOutputStream;
import java.util.concurrent.ThreadLocalRandom;

public class TicketTask implements Runnable{
    private int tickets = 100;
    private Object object = new Object();
    boolean flag = true;


    public void run(){
        //通过标记实现线程切换，让一个线程在同步函数中执行，一个线程在同步代码块中执行
        if(flag) {
            //线程任务中通常都有循坏结构
            while (true){
                synchronized (object){
                    if(tickets > 0){
                        //由于run方法是复写接口中的，run方法没有抛出异常，此时这里只能捕获异常，而不能抛出异常
                        //让线程在此冻结10毫秒
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread() + "恭喜你卖到票，票号" + tickets);
                        tickets--;
                    }
                }
            }
        }
        else {
            while (true){
                //调用sale函数完成卖票过程
                sale();
            }
        }
    }

    //将售票的代码封装到sale函数中
    private synchronized void sale() {
        if(tickets > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "恭喜你卖到票，票号" + tickets);
            tickets--;
        }
    }

    public static void main(String[] args) {
        //创建卖票任务
        TicketTask task = new TicketTask();

        //A窗口
        Thread t1 = new Thread(task);
        t1.setName("窗口A");
        //B窗口
        Thread t2 = new Thread(task);
        t2.setName("窗口B");
        //C窗口
        Thread t3 = new Thread(task);
        t3.setName("窗口C");
        //D窗口
        Thread t4 = new Thread(task);
        t4.setName("窗口D");
        //开启线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
