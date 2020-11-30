package homework1;

public class Demo05InvokeCook {
    private static void invokeCook(Cook cook){
        cook.makeFood();
    }

    public static void main(String[] args) {
        invokeCook(()-> {System.out.println("吃饭啦！");});
    }
}
