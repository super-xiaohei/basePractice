package JDK18;

public class Main {
    public static void main(String[] args) {
        //第一种方式
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();

        //第二种方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
            }
        }).start();

        //第三种方式(lambda表达式) ()->{}
        new Thread(()-> {System.out.println("start");}).start();
    }
}
