package net.suncaper.jvm;

/**
 * @author zyq
 * @date 2021/1/4 - 15:57
 */
public class SleepTest {
    public static void main(String[] args) {
        SleepTest sleepTest = new SleepTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleepTest.testMethodA();
            }
        },"线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sleepTest.testMethodB();
            }
        },"线程B").start();
    }


    public synchronized void testMethodA(){
        System.out.println("进入 " + Thread.currentThread().getName());
        try {
            System.out.println("开始等待 " + Thread.currentThread().getName());
            wait();
            System.out.println("结束等待 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出 " + Thread.currentThread().getName());
    }

    public synchronized void testMethodB(){
        System.out.println("进入 " + Thread.currentThread().getName());
        try {
            Thread.sleep(100);
            System.out.println("等待唤醒 " + Thread.currentThread().getName());
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出 " + Thread.currentThread().getName());
    }
}
