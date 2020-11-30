package functionalinterface;

import java.util.function.Supplier;


//supplier接口
//java.util.function.Supplier<T> 接口，它意味着"供给" , 对应的Lambda表达式需要“对外提供”一个符合泛型类 型的对象数据。
//抽象方法 : get，仅包含一个无参的方法： T get() 。用来获取一个泛型参数指定类型的对象数据。
public class Demo08Supplier {
    private static String getString(Supplier<String> function){
        return function.get();
    }

    public static void main(String[] args) {
        String msgA = "hello";
        String msgB = "world!";
        System.out.println(getString(()-> msgA + msgB));
    }
}
