package net.suncaper.ch01;

import java.util.concurrent.Semaphore;

/**
 * @author zyq
 * @date 2021/1/4 - 18:21
 */
public class BoundResource {
    private Integer permits;
    private Semaphore semaphore;


    public BoundResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    public void pass(){

        try {
            //申请过桥
            semaphore.acquire();
            //过桥
            doPass();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private void doPass() {
        System.out.println("开始过桥 同行多少人 " + (permits - semaphore.availablePermits()));
        //模拟过桥时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束过桥 同行多少人 " + (permits - semaphore.availablePermits()));
    }
}
