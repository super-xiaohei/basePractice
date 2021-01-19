package net.suncaper.ch02;

/**
 * @author zyq
 * @date 2021/1/5 - 15:34
 */
public class InterruptJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始执行线程1");
                while (true){
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join(); //因为t1里面有while（true），t2会一直等待t1结束在执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始执行线程2");

            }
        });

        t1.start();
        t2.start();
        t2.interrupt();
        Thread.sleep(1000);
        //t1.join();
        System.out.println("开始执行主线程");
    }
}
