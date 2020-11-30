package test;

import util.Person;

import java.util.Set;
import java.util.TreeMap;

/**
 * @author zyq
 * @date 2020/11/11 - 19:52
 */

//重写compareTo方法实现按年龄来排序
public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<Person,String> treeMap = new TreeMap<>();
        treeMap.put(new Person("张三",20),"小张");
        treeMap.put(new Person("李四",30),"小李");
        treeMap.put(new Person("王五",10),"小王");
        //得到key的同时得到key所对应的值
        Set<Person> keys = treeMap.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "---------->" + key.getName());
        }
    }
}
