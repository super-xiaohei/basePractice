package net.suncaper.ch05;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author zyq
 * @date 2021/1/6 - 10:06
 */
public class ServerMain {
    public static void main(String[] args) {
//        Host host = new Host(new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r);
//            }
//        });

        Host host = new Host(Executors.defaultThreadFactory());




        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        host.accept(String.valueOf(new Random().nextInt(100)));
                    }
                    }
            }).start();
        }
    }
}
