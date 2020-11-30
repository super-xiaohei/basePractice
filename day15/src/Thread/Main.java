package Thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //每隔200毫秒打印一个自定义的字符串
        //线程：需要处理什么数据：指定的字符转
        // 怎么处理：每隔200毫秒打印一次

        /*threadPrint.setName("打印机");

        threadPrint.start();//开机
        Thread.sleep(10000);//计算时间
        //关闭打印机
        *//*threadPrint.stop();//不询问，直接中断*//*
        threadPrint.close();*/
        String content = "秋天的第一杯奶茶";
        ThreadPrint threadPrint = new ThreadPrint(content);
        threadPrint.start();
        Thread.sleep(1000 );
        threadPrint.closeThread();
    }
}
