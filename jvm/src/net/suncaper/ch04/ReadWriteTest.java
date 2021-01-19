package net.suncaper.ch04;

import net.suncaper.ch04.ReadWrite;

/**
 * @author zyq
 * @date 2021/1/5 - 19:12
 */
public class ReadWriteTest {
    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        readWrite.write(String.valueOf((int)(Math.random()*10)+1));
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        readWrite.read();
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
