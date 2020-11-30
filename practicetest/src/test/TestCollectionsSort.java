package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zyq
 * @date 2020/11/11 - 19:41
 */
public class TestCollectionsSort {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(-1);
        integerList.add(3);
        integerList.add(3);
        integerList.add(-5);
        integerList.add(7);
        integerList.add(4);
        integerList.add(-9);
        integerList.add(-7);
        System.out.println("原始数组");
        System.out.println(integerList);
        System.out.println("-------------------------------------------------");
        Collections.reverse(integerList);//反转
        System.out.println("经过collections.reverse()反转后的数组为:");
        System.out.println(integerList);
        /* * void rotate(List list, int distance),旋转。
		 * 当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将
                * list的前distance个元素整体移到后面。*/
        System.out.println("------------------------------------------------");
        Collections.rotate(integerList,3);
        System.out.println("经过collections.rotate()旋转后3个后的数组为:");
        System.out.println(integerList);
        System.out.println("-----------------------------------------");

        Collections.shuffle(integerList);//随机排序
        System.out.println("经过collections.shuffle()随机排序后的数组为:");
        System.out.println(integerList);
        System.out.println("------------------------------------------");

        //定制排序的用法
        Collections.sort(integerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("定制排序后");
        System.out.println(integerList);
    }
}
