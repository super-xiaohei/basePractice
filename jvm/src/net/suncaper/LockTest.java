package net.suncaper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zyq
 * @date 2021/1/5 - 17:38
 */
public class LockTest {
    private static int num = 1000;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increase();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    decrease();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("当前数据 " + num);
    }



    public static void increase(){
        try {
            lock.lock();
            System.out.println("进入increase");
            int a = num;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = a + 1;
            num = a;
            if(true){
                return;
            }
            if(true){
                throw new RuntimeException("抛出异常");
            }
        }finally {
            lock.unlock();
        }
        System.out.println("退出increase");

    }


    public static synchronized void decrease(){
        try {
            lock.lock();
            System.out.println("进入decrease");
            int a = num;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = a - 1;
            num = a;
        }finally {
            lock.unlock();
        }
        System.out.println("退出decrease");
    }
}
