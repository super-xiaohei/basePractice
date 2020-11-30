package practice;

public class ThrowDemo {
    public static void main(String[] args) {
        int[] arr = {2,6,8,9};
        int index = 5;
        int element = getElement(arr,index);
        System.out.println(element);
        System.out.println("over");
    }

    public static int getElement(int[] arr,int index){
        if(index < 0 || index > arr.length - 1){
            throw new ArrayIndexOutOfBoundsException("数组下标越界了...");
        }
        int element = arr[index];
        return element;
    }
}
