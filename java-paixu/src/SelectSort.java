import org.junit.Test;

import java.util.Scanner;

public class SelectSort {
    @Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要排序的数据,每个数据之间用空格隔开...");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            String[] split = input.split("\\s+");
            int[] arr = new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            //选择
            for (int i = 0; i < arr.length; i++) {
               /* //默认第一个是最小的
                int min = arr[i];
                //记录最小的下标
                int index = i;*/
                //通过与后面的数据进行比较得出，最小值和下标
                for (int j = i + 1; j < arr.length; j++) {
                    /*if(min > arr[j]){
                        min = arr[j];
                        index = j;
                    }*/
                    if(arr[i] > arr[j]){
                        int temp;
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                //然后将最小值与本次循环的值交换，开始值交换
               /* int temp;
                temp = arr[i];
                arr[i] = min;
                arr[index] = temp;*/
                //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无序的最小值，做替换
            }
            System.out.println("选择排序后的数据为：");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}
