package Thread;

public class ThreadPrint extends Thread{
   /* private boolean sw = true;
    @Override
    public void run() {
        while (sw){
            System.out.println("哈哈哈");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(){
        this.sw = false;
    }*/
    private String content; //处理的数据
    private boolean sw =true;

    public ThreadPrint(String content) {
        this.content = content;
    }

    @Override
    public void run() {
        while (sw){
            //怎么处理
            System.out.println(content);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void closeThread(){
        this.sw = false;
    }

}
