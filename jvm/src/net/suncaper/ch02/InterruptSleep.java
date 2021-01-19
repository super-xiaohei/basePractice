package net.suncaper.ch02;

/**
 * @author zyq
 * @date 2021/1/5 - 15:17
 */
public class InterruptSleep {
    public static void main(String[] args) throws InterruptedException {
        InterruptSleep interruptSleep = new InterruptSleep();
        Thread t1 = new Thread(() -> {
            System.out.println("开始睡一天");
            try {
                Thread.sleep(1000 * 60 * 60 * 24);
            } catch (InterruptedException e) {
                System.out.println("睡眠被打断了");
                e.printStackTrace();
                try {
                    System.out.println("我还想继续睡1秒");
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            System.out.println("睡眠结束");
        });

       /* Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               interruptSleep.waitThread();
            }
        });


        t2.start();
        System.out.println("2秒后满足等待要求");
        Thread.sleep(2000);
        //t2.interrupt();*/


        t1.start();

        System.out.println("2秒后开始打断睡眠");
        Thread.sleep(2000);
        System.out.println("执行打断睡眠");
        t1.interrupt();


    }

    public synchronized void waitThread(){
        System.out.println("开始等待");
        try {
            wait(10000); //必须放在synchronized块里面.wait()可以设置时间自动醒来
        } catch (InterruptedException e) {
            System.out.println("等待被打断了");
            e.printStackTrace();
        }
        System.out.println("等待结束");
    }
    public void endWait(){
        this.notify();
    }
}
