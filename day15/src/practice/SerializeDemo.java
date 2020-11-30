package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化
 */
public class SerializeDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("彭于晏");
        employee.setAddress("四川理工学院");
        employee.setAge(20);

        //创建序列化对象
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E://employee.txt"));
            //写出对象
            objectOutputStream.writeObject(employee);
            //释放资源
            objectOutputStream.close();
            System.out.println("Serialized data is saved"); //姓名，地址被序列化，年龄没有被序列化。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
