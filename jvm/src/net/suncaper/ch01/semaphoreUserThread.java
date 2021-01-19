package net.suncaper.ch01;

/**
 * @author zyq
 * @date 2021/1/4 - 18:25
 */
public class semaphoreUserThread implements Runnable{

    private BoundResource boundResource;
    private String name;

    public semaphoreUserThread(BoundResource boundResource, String name) {
        this.boundResource = boundResource;
        this.name = name;
    }

    public semaphoreUserThread() {
    }

    @Override
    public void run() {
        while (true){
            boundResource.pass();
        }
    }
}
