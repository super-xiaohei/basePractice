package net.suncaper.ch08;

/**
 * @author zyq
 * @date 2021/1/11 - 11:18
 *
 * Volatile并不能保证原子性，只可以确保可见性
 */
public class VolatileTest {
    private int num = 100000000;
    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                volatileTest.increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                volatileTest.decrease();
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("最后的结果是 " + volatileTest.num);
        System.out.println("执行的时间是 " + (end - start)/1000 + " 秒");
    }

    public void increase(){
        num++;
    }

    public void decrease(){
        num--;
    }
}
