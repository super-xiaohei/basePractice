package net.suncaper.ch06;

import java.util.concurrent.*;

/**
 * @author zyq
 * @date 2021/1/6 - 17:08
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("进入线程");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("结束线程");
//            }
//        });


        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("进入线程");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("结束线程");

                return "返回执行结果";
            }
        });

        executorService.shutdown();
        System.out.println("主线程执行");
        //Runnable 和 Callable 的区别，Runnable不会返回值，Callable可以返回值
        //Callable返回一个Future<返回的数据类型>，调用这个future的get()方法能够等待线程执行完再获取结果
        System.out.println(future.get());  //在未来的某一个时间节点拿到返回的结果   （返回执行结果）
        System.out.println("主线程执行完");
    }
}
