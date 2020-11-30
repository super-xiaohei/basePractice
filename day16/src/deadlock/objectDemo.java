package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class objectDemo {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    public void fn1(){
        lock1.lock();
        System.out.println(Thread.currentThread().getName() + "处于fn1（）方法中：拿到lock1，等待lock2");
        try {
            Thread.sleep(5);
            fn2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fn2() {
        lock2.lock();
        System.out.println(Thread.currentThread().getName() + "处于fn2（）方法中：拿到lock2，等待lock1");
        try {
            Thread.sleep(5);
            fn1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
