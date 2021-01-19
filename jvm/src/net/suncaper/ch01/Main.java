package net.suncaper.ch01;

/**
 * @author zyq
 * @date 2021/1/4 - 17:49
 */
public class Main {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        UserThread userA = new UserThread(bridge, "A的手", "A的脚");
        UserThread userB = new UserThread(bridge, "B的手", "B的脚");
        UserThread userC = new UserThread(bridge, "C的手", "C的脚");

        new Thread(userA).start();
        new Thread(userB).start();
        new Thread(userC).start();
    }
}
