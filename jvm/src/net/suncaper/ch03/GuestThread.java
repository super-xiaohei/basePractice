package net.suncaper.ch03;

import javafx.scene.control.TableColumn;

/**
 * @author zyq
 * @date 2021/1/5 - 15:54
 */
public class GuestThread implements Runnable{
    private String name;
    private Table table;

    public GuestThread(String name,Table table){
        this.name = name;
        this.table = table;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(name + "等待获取蛋糕");
            String s = table.get();
            System.out.println(name + "拿取了蛋糕" + s);
        }
    }
}
