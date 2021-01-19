package net.suncaper.ch01;

/**
 * @author zyq
 * @date 2021/1/4 - 17:39
 */
public class Bridge {
    private int counter = 0;
    private String hand = "";
    private String foot = "";


    public synchronized void pass(String hand,String foot){
        this.counter++;
        this.hand = hand;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.foot = foot;
        check();
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "counter=" + counter +
                ", hand='" + hand + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }

    public void check(){
        if (hand.charAt(0) != foot.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
