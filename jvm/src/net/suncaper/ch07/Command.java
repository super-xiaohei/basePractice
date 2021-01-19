package net.suncaper.ch07;

/**
 * @author zyq
 * @date 2021/1/6 - 18:06
 */
public class Command implements Runnable{
    @Override
    public void run() {
        System.out.println("进入线程" + Thread.currentThread().getName());
        this.doCommand();
        System.out.println("退出线程" + Thread.currentThread().getName());
    }

    public void doCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
