package lambda;

import java.util.Arrays;

public class Demo07ComparatorLambda {
    public static void main(String[] args) {
        Person[] array = {
                new Person("古力娜扎", 19),
                new Person("迪丽热巴", 18),
                new Person("马尔扎哈", 20) };
        //lambda写法
        Arrays.sort(array,(Person a,Person b)->{return a.getAge() - b.getAge();});
        for (Person person : array) {
            System.out.println(person);
        }
        //进一步简化
       /**在Lambda标准格式的基础上，使用省略写法的规则为：
        小括号内参数的类型可以省略；
        如果小括号内有且仅有一个参，则小括号可以省略；
        如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。
        */
        Arrays.sort(array,(a,b)->a.getAge() - b.getAge());
        for (Person person : array) {
            System.out.println(person);
        }
    }
}
