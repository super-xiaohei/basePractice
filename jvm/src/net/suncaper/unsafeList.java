package net.suncaper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zyq
 * @date 2021/1/4 - 18:03
 */
public class unsafeList {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("thread a " + i);
                    list.remove("thread a " + i);
                }
            }
        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("thread b " + i);
                    list.remove("thread b " + i);
                }
            }
        });

        threadA.start();
        threadB.start();


        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("list的大小为 " + list.size());
    }
}
