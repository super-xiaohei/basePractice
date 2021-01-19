package net.suncaper.ch05;

import java.util.concurrent.ThreadFactory;

/**
 * @author zyq
 * @date 2021/1/6 - 10:06
 */
public class Host {
    private ThreadFactory threadFactory;

    public Host(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public synchronized void accept(String message){
        System.out.println("接收到消息 " + message);
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                handleRequest(message);
            }
        }).start();
        //handleRequest(message);
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                handleRequest(message);
            }
        }).start();*/
        System.out.println("返回消息 " + message);
    }

    /**
     * 处理请求
     * @param message
     */
    public void handleRequest(String message){
        System.out.println("线程名 " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
