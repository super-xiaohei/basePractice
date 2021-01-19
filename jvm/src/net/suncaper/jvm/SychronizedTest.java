package net.suncaper.jvm;

/**
 * @author zyq
 * @date 2021/1/4 - 14:52
 */
public class SychronizedTest {
    private Long amount = 1000000L;
    public static void main(String[] args) {
        SychronizedTest sychronizedTest = new SychronizedTest();

        //线程1
        new Thread(new Runnable() {  //内部类
            @Override
            public void run() {
                for(long i = 0; i < 200000; i++){
                    sychronizedTest.increase();
                }
                System.out.println("最后剩余:" + sychronizedTest.amount);
            }
        }).start();

        //线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(long i = 0; i < 200000; i++){
                    sychronizedTest.decrease();
                }
                System.out.println("最后剩余:" + sychronizedTest.amount);
            }
        }).start();

    }

    /**
     * synchronized 只允许一个线程去持有这个锁，其他线程如果要访问这个方法必须等待
     * （1）synchronized 加在方法上，锁的是当前(this)对象
     * （2）synchronized 加在静态方法上，锁的是类.class对象
     */
    public synchronized void increase(){
        amount++;

       /* Long CurAmount = amount;
        CurAmount = CurAmount + 1;
        amount = CurAmount;*/
    }

    public synchronized void decrease(){
        amount--;
        /*Long CurAmount = amount;
        CurAmount = CurAmount - 1;
        amount = CurAmount;*/
    }
}
