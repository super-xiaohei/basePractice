package homework2;

import java.util.Calendar;

public class Demo08InvokeCalc {
    private static void invokeCalc(int a, int b, Calculator calculator){
        int result = calculator.calc(a, b);
        System.out.println("两个数相加的结果是：" + result);
    }

    public static void main(String[] args) {
        invokeCalc(130,130,(a,b)->{ return a+b;});
    }
}
