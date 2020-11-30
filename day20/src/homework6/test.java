package homework6;

import static javafx.scene.input.KeyCode.L;

public class test {
    private static void invokeCalculate(long a,long b,Calculator2<Long,Long> calculator2){
        System.out.println("结果为：" +  calculator2.calculate(a,b));
    }

    public static void main(String[] args) {
        invokeCalculate(10L,10L,(a,b)-> a + b);
        invokeCalculate(10L,10L,(a,b)-> a * b);
    }
}
