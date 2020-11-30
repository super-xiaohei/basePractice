package functionalinterface;

public class Demo09FunctionalInterface {
    //使用自定义的函数时接口作为函数方法参数
    private static void dosomething(MyFunctionalInterface myFunctionalInterface){
        //调用自定义的函数式接口方法
        myFunctionalInterface.myMethod();
    }

    public static void main(String[] args) {
        //调用函数式接口方法
        dosomething(()-> System.out.println("Lambda执行啦！"));
    }
}
