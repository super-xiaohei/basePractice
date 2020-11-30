package homework9;

import java.util.function.Function;

/**
 * 请使用Function进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 * String str = "赵丽颖,20";
 *     将字符串截取数字年龄部分，得到字符串；
 *     将上一步的字符串转换成为int类型的数字；
 *     将上一步的int数字累加100，得到结果int数字
 */
public class testFunction {
    private static void method(Function<String,Integer> function,String string){
        Integer integer = function.apply(string);
        System.out.println(integer + 100);
    }

    public static void main(String[] args) {
        String str = "赵丽颖,20";
        /*String substring = str.substring(4, str.length());
        System.out.println(substring);*/
        method(s -> Integer.parseInt(s),str.substring(4,str.length()));
    }
}
