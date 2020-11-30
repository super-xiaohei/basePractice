package homework1;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 选择不同的命令实现增删改查
 */
public class Test1 {
    @Test
    public static void main(String[] args) throws IOException{
        List<Emps> empsList = new ArrayList<>();
        Emps emps = new Emps();
        empsList.add(emps);
        File file = new File("E://emps.txt"); //定义一个file对象，用来初始化FileReader
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println("欢迎使用员工管理系统...");
        System.out.println("请输入命令(add/select/update/delete)");
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileOutputStream(file,true));
        switch (scanner.nextLine()){
            case "add":
                System.out.println("请输入员工的基本信息，用逗号隔开");
                String str = scanner.nextLine();
                String[] split = str.split(",");
                emps.setNo(split[0].trim());
                emps.setName(split[1].trim());
                emps.setSex(split[2].trim());
                emps.setAge(Integer.parseInt(split[3].trim()));
                emps.setBirthday(split[4].trim());
                for (Emps empslist : empsList) {
                    out.println(empslist.toString());
                    out.flush();
                    out.close();
                }
                break;
            case "select":
                System.out.println("请输入要查询的员工的姓名：");
                String str1 = scanner.nextLine();
                FileReader fileReader = new FileReader(file); //定义一个fileReader对象，用来初始化BufferedReader
                BufferedReader bufferedReader = new BufferedReader(fileReader);//new一个BufferedReader对象，将文件内容读取到缓存
                /*StringBuilder stringBuilder = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中(此处不用)*/
                Scanner scanner1 = new Scanner(bufferedReader);
                System.out.println("查询到的结果如下:");
                while (scanner1.hasNext()){
                    String eachData = scanner1.nextLine();
                    if(eachData != null && eachData.length() > 0){
                        String[] split1 = eachData.split(",");
                        emps.setNo(split1[0]);
                        emps.setName(split1[1]);
                        emps.setSex(split1[2]);
                        emps.setAge(Integer.parseInt(split1[3].trim()));
                        emps.setBirthday(split1[4]);
                        List<String> nameList = empsList.stream().map(Emps::getName).collect(Collectors.toList());
                        for (int i = 0; i < nameList.size(); i++) {
                            if(str1.equals(nameList.get(i))){
                                System.out.println(empsList.toString());
                            }
                        }
                    }
                }
                break;
            case "update":
                System.out.println("请输入要修改的人员的姓名：");
                break;
            case "delete":
                System.out.println("请输入要删除的人员的姓名：");

        }
    }
}
