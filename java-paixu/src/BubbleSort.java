import org.junit.Test;

import java.util.Scanner;

public class BubbleSort {
    @Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        System.out.println("请输入要排序的数据,每个数据之间用空格隔开...");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            String[] split = input.split("\\s+");
            arr = new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            //冒泡排序
            for (int i = 0; i < arr.length; i++) { //外层循环，遍历的次数
                for(int j = 1;j < arr.length - i;j++ ){ //内层循环，升序，内层循环一次，获取一个最大值
                    if(arr[j - 1] > arr[j]){
                        int temp;
                        temp = arr[j -1];
                        arr[j -1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println("冒泡排序之后的数据为：");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}
