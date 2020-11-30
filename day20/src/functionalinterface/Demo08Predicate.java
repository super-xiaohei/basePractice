package functionalinterface;


import java.util.function.Predicate;

//predicate接口
public class Demo08Predicate {
    private static void method(Predicate<String> predicate,String string){
        boolean result = predicate.test(string);
        System.out.println("字符串很长吗? " + result);
    }

    public static void main(String[] args) {
        method((s)-> s.length() > 5,"helloworld!");
    }
}
