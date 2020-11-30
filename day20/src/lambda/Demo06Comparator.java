package lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Demo06Comparator {
    public static void main(String[] args) {
        Person[] array = new Person[]{new Person("古力娜扎",16),new Person("迪丽热巴",18),new Person("马儿扎哈",20)};
        //匿名内部类
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Arrays.sort(array,comparator);//第二个参数为排序规则，即Comparator接口实例
        for (Person person : array) {
            System.out.println(person);
        }
    }
}
