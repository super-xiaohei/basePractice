package test;

public class Test2 {
    public static int a = 1;
    public static void main(String[] args) {
        int a = 10;
        a++;
        Test2.a++;
        Test2 t=new Test2();
        System.out.println("a=" + a + " t.a=" + t.a);

    }
}
