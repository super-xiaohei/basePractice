package homework3;

import java.util.function.Supplier;

public class Main {
    private static Person getPerson(Supplier<Person> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        System.out.println(getPerson(()->{return new Person("小黑",20);}));
    }
}
