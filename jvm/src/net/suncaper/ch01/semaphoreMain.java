package net.suncaper.ch01;

/**
 * @author zyq
 * @date 2021/1/4 - 18:25
 */
public class semaphoreMain {
    public static void main(String[] args) {
        BoundResource boundResource = new BoundResource(2);

        Thread threadA = new Thread(new semaphoreUserThread(boundResource, "A"));
        Thread threadB = new Thread(new semaphoreUserThread(boundResource, "B"));
        Thread threadC = new Thread(new semaphoreUserThread(boundResource, "C"));
        Thread threadD = new Thread(new semaphoreUserThread(boundResource, "D"));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
