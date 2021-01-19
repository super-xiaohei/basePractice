package net.suncaper.jvm;

/**
 * @author zyq
 * @date 2021/1/4 - 14:32
 */
public class ThreadTest {
    //主线程
    public static void main(String[] args) {
        //new MyThread().start();
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        for(int i = 0; i < 1000; i++){
            System.out.println("当前数字:" + i);
        }
    }

    public static class MyThread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                System.out.println("线程数字:" + i);

            }
        }
    }


    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                System.out.println("线程数字:" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
