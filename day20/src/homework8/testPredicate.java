package homework8;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 数组当中有多条“姓名+性别”的信息如下，
 * 请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，需要同时满足两个条件：
 * 必须为女生；姓名为4个字。
 */
public class testPredicate {
     public static void PrintInfo(Predicate<String> name, Predicate<String> gendar, String[] arr){
          List<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean b = name.and(gendar).test(s);
            if(b){
                list.add(s);
            }
        }
         for (String s : list) {
             System.out.println(s);
         }
    }


    public static void main(String[] args) {
        /*String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男","赵丽颖,女"  };
        for (String s : array) {
            int s1 = s.split(",")[0].length();
            String s2 = s.split(",")[1];
            System.out.println(s1);
            System.out.println(s2);
        }*/
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男","赵丽颖,女"  };
        PrintInfo(s ->
            s.split(",")[0].length() == 4,
                s ->
            s.split(",")[1].equals("女"),array);
    }
}
