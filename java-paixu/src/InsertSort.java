import org.junit.Test;

import java.util.Scanner;

public class InsertSort {
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
            //插入排序
            for (int i = 1; i < arr.length; i++) { //外层循环，从第二个开始比较
                for(int j = i; j > 0;j--){//内层循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                    if(arr[j -1] > arr[j]){
                        int temp;
                        temp = arr[j -1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }else {
                        //如果不小于，说明插入完毕，退出内层循环
                        break;
                    }
                }
            }
            System.out.println("插入排序之后的数据为：");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}
