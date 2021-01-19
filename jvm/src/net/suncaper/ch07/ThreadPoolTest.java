package net.suncaper.ch07;

import java.util.concurrent.*;

/**
 * @author zyq
 * @date 2021/1/6 - 18:05
 */

public class ThreadPoolTest {
    private static final int CORE_POOL_SIZE = 3; //线程池的核心线程数量
    private static final int MAX_POOL_SIZE = 5;  //线程池的最大线程数
    private static final long KEEP_ALIVE_TIME = 5; // 当线程数大于核心线程数时，多余的空闲线程存活的最长时间
    private static final TimeUnit UTIL = TimeUnit.SECONDS; //时间单位
    private static final BlockingQueue<Runnable> QUEUE = new ArrayBlockingQueue<>(100); //任务队列，用来储存等待执行任务的队列



    public static void main(String[] args) {

        //最推荐的创建线程池的方式
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, UTIL, QUEUE, new ThreadPoolExecutor.CallerRunsPolicy());
        //第二种,非常不建议使用（缺点自己去了解）
        Executors.newFixedThreadPool(5);
        //第三种,不建议
        Executors.newSingleThreadExecutor();
        //第三种，不建议
        Executors.newCachedThreadPool();
        //第四种
        Executors.newScheduledThreadPool(5);



        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new Command());
        }


        //shutdown 会在所有线程执行完成之后在执行
        threadPoolExecutor.shutdown();
    }
}
