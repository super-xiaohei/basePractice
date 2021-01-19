package net.suncaper.ch09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyq
 * @date 2021/1/11 - 15:44
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("语文",1);
        hashMap.put("aaa",2);
        hashMap.put("bbb",3);
        hashMap.put("ccc",4);
        hashMap.put("ddd",5);
        hashMap.put("eee",6);
        hashMap.put("fff",7);
        hashMap.put("www",8);
        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " :: " + stringIntegerEntry.getValue());
        }
    }
}
