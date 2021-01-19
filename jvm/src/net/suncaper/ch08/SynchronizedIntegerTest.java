package net.suncaper.ch08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zyq
 * @date 2021/1/11 - 11:04
 */
public class SynchronizedIntegerTest {
    private int num = 100000000;
    public static void main(String[] args) throws InterruptedException {
        SynchronizedIntegerTest synchronizedIntegerTest = new SynchronizedIntegerTest();
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
               synchronizedIntegerTest.increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                synchronizedIntegerTest.decrease();
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("最后的结果是 " + synchronizedIntegerTest.num);
        System.out.println("执行的时间是 " + (end - start)/1000 + " 秒");
    }

    public synchronized void increase(){
        num++;
    }

    public synchronized void decrease(){
        num--;
    }
}
