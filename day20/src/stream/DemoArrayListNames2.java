package stream;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//使用Stream方式
public class DemoArrayListNames2 {
    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>();
        listOne.add("迪丽热巴");
        listOne.add("宋远桥");
        listOne.add("苏星河");
        listOne.add("老子");
        listOne.add("庄子");
        listOne.add("孙子");
        listOne.add("洪七公");
        List<String> listTwo = new ArrayList<>();
        listTwo.add("古力娜扎");
        listTwo.add("张无忌");
        listTwo.add("张三丰");
        listTwo.add("赵丽颖");
        listTwo.add("张二狗");
        listTwo.add("张天爱");
        listTwo.add("张三");
        //第一个队伍只要名字为3个字的成员姓名；
        //第一个队伍筛选之后只要前3个人；
        Stream<String> stringStream1 = listOne.stream().filter(string -> string.length() == 3).limit(3);
        stringStream1.forEach(System.out::println);
        // 第二个队伍只要姓张的成员姓名；
        // 第二个队伍筛选之后不要前2个人；
        Stream<String> stringStream2 = listTwo.stream().filter(string -> string.startsWith("张")).skip(2);
        stringStream2.forEach(System.out::println);
        //将两个队伍合并为一个队伍
        // 根据姓名创建Person对象；
        // 打印整个队伍的Person对象信息
        Stream.concat(stringStream1,stringStream2).map(Person::new).forEach(System.out::println);
    }
}
