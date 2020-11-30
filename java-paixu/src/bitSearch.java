import org.junit.Test;

import java.util.Scanner;

public class bitSearch {
    @Test
    public static void main(String[] args) {
        int[] arr = new int[]{22, 45, 63, 66, 77, 88, 89, 99};
        int data = 66;
        Search(arr,data);
    }
    @Test
    public static int Search(int[] array,int a){
        int lo = 0;
        int hi = array.length - 1;
        int mid = (lo + hi)/2;
        while (lo <= hi){
            if(array[mid] == a){
                return mid + 1;
            }else if(array[mid] < a){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return 0;
    }
}
