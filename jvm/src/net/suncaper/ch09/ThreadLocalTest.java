package net.suncaper.ch09;

/**
 * @author zyq
 * @date 2021/1/11 - 11:33
 *
 * ThreadLocal避免了线程安全问题，每个线程都有自己的事，但是会发生oom问题
 * ThreadLocal 可以有多个
 */
public class ThreadLocalTest {
    //private String message;

    private ThreadLocal<String> message = ThreadLocal.withInitial(()->"初始的消息");
    private ThreadLocal<String> user = ThreadLocal.withInitial(()->"初始的消息");

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalTest.message.set("这是第一个线程");
                threadLocalTest.user.set("这是第一个用户");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocalTest.message.get());
                System.out.println(threadLocalTest.user.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalTest.message.set("这是第二个线程");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocalTest.message.get());
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(threadLocalTest.message.get());
    }
}
