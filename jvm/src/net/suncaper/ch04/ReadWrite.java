package net.suncaper.ch04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zyq
 * @date 2021/1/5 - 17:55
 */
public class ReadWrite {
    private String data;
    ReentrantReadWriteLock readWriteLock  = new ReentrantReadWriteLock();

    public String read(){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备读数据");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName() + "读出的数据为" + data);

            return this.data;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void write(String data){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备写数据");
            Thread.sleep((long)(Math.random()*1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入的数据为" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
