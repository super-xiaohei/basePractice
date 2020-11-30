package homework4;

public class test {
    private static void showLongTime(CurrentTimePrinter timePrinter){
        timePrinter.printCurrentTime();
    }

    public static void main(String[] args) {
       showLongTime(()-> System.out.println("当前的毫秒值为：" + System.currentTimeMillis()));
    }
}
