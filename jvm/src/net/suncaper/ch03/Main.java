package net.suncaper.ch03;

import javafx.scene.control.TableColumn;

/**
 * @author zyq
 * @date 2021/1/5 - 15:56
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        Thread maker = new Thread(new MakerThread(table));

        Thread t1 = new Thread(new GuestThread("张三", table));
        Thread t2 = new Thread(new GuestThread("张三", table));
        Thread t3 = new Thread(new GuestThread("张三", table));

        maker.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
