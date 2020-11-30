package producerandconsumer15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private int count = 20;
    private int current = 0;
    private Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public Resource(){}

    public Resource(int count) {
        this.count = count;
    }

    public void add(int num){
        lock.lock();
        while ((current+ num) >= count){
            try {
                notFull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        current = current + num;
        System.out.println(Thread.currentThread().getName() + ": >>>>" + (int)(Math.random()*(10 - 1 + 1) + 1) +">>>> 添加" + num + " 个商品,当前数量是:" + current);
        notEmpty.signalAll();
        lock.unlock();
    }

    public void reduce(int num){
        lock.lock();
        while ((current - num) <= 0){
            try {
                notEmpty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        current = current - num;
        System.out.println(Thread.currentThread().getName() + ": >>>>" + (int)(Math.random()*(10 - 1 + 1) + 1) + ">>>> 减少" + num + " 个商品,当前数量是:" + current);
        notFull.signalAll();
        lock.unlock();
    }
}
