package net.suncaper.ch03;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zyq
 * @date 2021/1/5 - 15:49
 */
public class Table {
    private ArrayBlockingQueue queue = new ArrayBlockingQueue<String>(3);

    public void put(String name) throws InterruptedException {
        queue.put(name);
    }

    public String get(){
        try {
            return (String) queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
