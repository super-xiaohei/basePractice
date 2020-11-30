package homework7;

import java.io.PrintWriter;
import java.util.function.Consumer;

/**
 * 下面的字符串数组当中存有多条信息，请按照格式“姓名：XX。性别：XX。”的格式将信息打印出来。
 */
public class testPrint {
    /*public static void Print(String[] array){
        String name = null;
        String sex = null;
        for (int i = 0; i < array.length; i++) {
            String[] split = array[i].split(",");
            name = split[0];
            sex = split[1];
            System.out.println("姓名：" + name + " 性别：" + sex);
        }
    }
    public static void main(String[] args) {
        String[] array = new String[]{ "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        Print(array);
    }*/
    //使用consumer函数式接口
    //定义一个方法，参数传递String类型的数组和两个Consumer接口，泛型使用String
    private static void consumerPrint(Consumer<String> consumer1,Consumer<String> consumer2,String[] arr){
        //遍历字符串数组
        for (String s : arr) {
            //使用andThen方法连接两个Consumer接口，消费字符串
            consumer1.andThen(consumer2).accept(s);
        }
    }

    public static void main(String[] args) {
        //定义一个字符串类型的数组
        String[] array = new String[]{ "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        //调用consumerPrint方法，传递字符串数组，和两个Lambda表达式
        consumerPrint((s1)->{
            //消费方式：对s进行切割，获取姓名，按照指定的格式输出
            String name = s1.split(",")[0];
            System.out.print("姓名: " + name + ",");
        },(s2)->{
            //消费方式：对s进行切割，获取姓名，按照指定的格式输出
            String sex = s2.split(",")[1];
            System.out.println("性别: " + sex + ".");
        },array);
    }
}
