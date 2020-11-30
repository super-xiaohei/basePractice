package dataconstruct;

import java.util.Scanner;

/**
 * @author zyq
 * @date 2020/11/12 - 14:08
 */
public class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组栈
    //栈顶，初始化为-1
    private int top = -1;
    //构造函数
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize]; //初始化栈
    }
    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //进栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈已经满了");
            return;
        }else {
            top = top + 1;
            stack[top] = value;
        }
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            //System.out.println("栈是空的，不需要出栈");
            throw new RuntimeException("栈是空的，无法在执行出栈操作");
        }else {
            int value = stack[top];
            top = top - 1;
            return value;
        }
    }
    //显示栈内数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈是空的");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[i] = " + stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(6);
        String order = null;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("请输入一下命令，执行相关操作");
            System.out.println("push : 入栈操作");
            System.out.println("pop : 出栈操作");
            System.out.println("show : 显示栈内数据");
            System.out.println("exit : 退出程序");
            order = scanner.next();
            switch (order){
                case "push":
                    System.out.println("请输入你想要的插入的数据");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    int p = arrayStack.pop();
                    System.out.println("弹出的数据为" + p);
                    break;
                case "show":
                    System.out.println("栈内数据如下");
                    arrayStack.list();
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
            System.out.println("程序退出~~~");
        }
    }

}
