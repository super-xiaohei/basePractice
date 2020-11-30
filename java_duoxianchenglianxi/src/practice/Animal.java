package practice;

import java.io.Serializable;
import java.util.stream.Stream;

public class Animal implements Serializable {
    private String name;//动物名字
    private String desc;//动物的描述
    //定义一个标记，如果这个标记为true则表示可以生产，否则表示只能消费不能生产
    private boolean flag = true;

    /**
     * 该方法用来生产
     * @param name
     * @param desc
     */
    public synchronized void set(String name,String desc){
        if(!this.flag){
            //在此等待
            try {
                super.wait();
            } catch (Exception e) {
            }
        }
        this.name = name;
        this.desc = desc;
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }

        //修改生产标记（表示此时不能生产了，等待消费者消费完毕后才能生产）
        flag = false;
        //告诉消费者可以消费了（唤醒消费者线程）
        super.notify();
    }


    /**
     * 该方法用来消费
     */

    public synchronized void get(){
        if(this.flag){
            //等待生产者的唤醒
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }
        System.out.println(this.name + "- - - - - ->" + this.desc);
        //修改生产标记
        this.flag = true;
        //唤醒生产者线程
        super.notify();
    }
}
