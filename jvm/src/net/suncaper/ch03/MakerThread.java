package net.suncaper.ch03;

import javafx.scene.control.TableColumn;
import sun.awt.windows.ThemeReader;

/**
 * @author zyq
 * @date 2021/1/5 - 15:48
 */
public class MakerThread implements Runnable {

    private static int id = 0;
    private Table table;

    public MakerThread(Table table) {
        this.table = table;
    }

    private static synchronized int nexId(){
        return id++;
    }
    @Override
    public void run() {
       while (true){
           int id = nexId();
           if(id < 1000){
               System.out.println("做了新蛋糕" + id);
               try {
                   table.put("蛋糕" + id);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }


}
