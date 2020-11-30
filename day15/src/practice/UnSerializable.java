package practice;

import java.io.*;

public class UnSerializable {
    public static void main(String[] args) {
        Employee employee1 = null;
        try {
            //创建反序列化流
            FileInputStream fileInputStream = new FileInputStream("E://employee.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //读取一个对象
            employee1 = (Employee)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            //捕获其他异常
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //捕获类找不到异常
            System.out.println("Employee class not found");
            e.printStackTrace();
            return;
        }
        System.out.println("Name: " + employee1.getName()); // 彭于晏
        System.out.println("Address: " + employee1.getAddress()); // 四川理工学院
        System.out.println("age: " + employee1.getAge()); // 0
    }
}
