package thread;

public class MyObject {
    private int vv = 0;
    //private int lock = 0;
    private String lock = "智能锁";
    public synchronized  void add(){ //同步锁
        for (int i = 0; i < 1000; i++) {
            synchronized (lock){ //同步锁
                vv = vv + 1;
            }
            /*if(lock  == 0){  //思路没问题，锁太普通了
                lock = 1;
                vv = vv + 1;
                lock = 0;
            }*/
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + vv);
    }
}
