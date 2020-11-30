package stream;

import java.util.ArrayList;
import java.util.List;

/**
 *  Stream综合案例
 * 现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以 下若干操作步骤：
 * 1. 第一个队伍只要名字为3个字的成员姓名；
 * 2. 第一个队伍筛选之后只要前3个人；
 * 3. 第二个队伍只要姓张的成员姓名；
 * 4. 第二个队伍筛选之后不要前2个人；
 * 5. 将两个队伍合并为一个队伍；
 * 6. 根据姓名创建 Person 对象；
 * 7. 打印整个队伍的Person对象信息。
 */
//普通的foreach循环
public class DemoArrayListNames {

    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>();
        listOne.add("迪丽热巴");
        listOne.add("宋远桥");
        listOne.add("苏星河");
        listOne.add("老子");
        listOne.add("庄子");
        listOne.add("孙子");
        listOne.add("洪七公");
        List<String> listTwo = new ArrayList<>();
        listTwo.add("古力娜扎");
        listTwo.add("张无忌");
        listTwo.add("张三丰");
        listTwo.add("赵丽颖");
        listTwo.add("张二狗");
        listTwo.add("张天爱");
        listTwo.add("张三");
        //第一个队伍只要名字为3个字的成员姓名
        List<String> oneA = new ArrayList<>();
        for (String name : listOne) {
            if(name.length() == 3){
                oneA.add(name);
            }
        }
        System.out.println(oneA);
        //第一个队伍删选后只要前三个人
        List<String> oneB = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            oneB.add(oneA.get(i));
        }
        System.out.println(oneB);
        //第二个队伍只要姓张的成员姓名
        List<String> twoA = new ArrayList<>();
        for (String name : listTwo) {
            if(name.startsWith("张")){
                twoA.add(name);
            }
        }
        System.out.println(twoA);
        //第二个队伍筛选后不要前两个人
        List<String> twoB = new ArrayList<>();
        for (int i = 2; i < twoA.size(); i++) {
            twoB.add(twoA.get(i));
        }
        System.out.println(twoB);
        //将两个队伍合并为一个队伍
        List<String> totalNames = new ArrayList<>();
        totalNames.addAll(listOne);
        totalNames.addAll(listTwo);
        System.out.println(totalNames);
        //根据姓名创建Person对象
        List<Person> totalPersonList = new ArrayList<>();
        for (String totalName : totalNames) {
            totalPersonList.add(new Person(totalName));
        }
        System.out.println(totalPersonList);
        //循环打印输出整个队伍的Person对象信息
        for (Person person : totalPersonList) {
            System.out.println(person);
        }
    }

}
