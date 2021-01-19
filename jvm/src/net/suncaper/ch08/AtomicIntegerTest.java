package net.suncaper.ch08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zyq
 * @date 2021/1/11 - 10:52
 */
public class AtomicIntegerTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(100000000);
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                atomicInteger.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                atomicInteger.decrementAndGet();
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("最后的结果是 " + atomicInteger);
        System.out.println("执行的时间是 " + (end - start)/1000 + " 秒");
    }
}
