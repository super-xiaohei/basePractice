package functionalinterface;


import javax.print.DocFlavor;
import java.util.function.Consumer;

//consumer接口
//java.util.function.Consumer<T> 接口则正好相反，它不是生产一个数据，而是消费一个数据，其数据类型由泛 型参数决定。
//抽象方法：accept, Consumer 接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据。
public class Demo08Consumer {
    private static void consumeString(Consumer<String> function, String s){
        function.accept(s);
    }

    public static void main(String[] args) {
        consumeString((s)-> System.out.println(s),"呵呵!");
    }
}
