package deadlock;

public class Main {
    public static void main(String[] args) {
        objectDemo objectDemo = new objectDemo();
        new Thread(){
            public void run(){
                objectDemo.fn1();
            }
        }.start();
        new Thread(){
            public void run(){
                objectDemo.fn2();
            }
        }.start();
    }
}
