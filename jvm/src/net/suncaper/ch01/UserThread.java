package net.suncaper.ch01;

/**
 * @author zyq
 * @date 2021/1/4 - 17:37
 */
public class UserThread implements Runnable {
    private Bridge bridge;
    private String hand;
    private String foot;

    public UserThread(Bridge bridge, String hand, String foot) {
        this.bridge = bridge;
        this.hand = hand;
        this.foot = foot;
    }

    public UserThread() {
    }

    @Override
    public void run() {
        while (true){
            bridge.pass(hand,foot);
        }
    }
}
