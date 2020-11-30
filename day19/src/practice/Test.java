package practice;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        //1.1 创建Properties对象
        Properties properties = new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("practice/pro.properties");
        properties.load(in);
        //2.获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //3.加载该类进内存
        Class<?> aClass = Class.forName(className);
        System.out.println(aClass.getSimpleName());//Student
        //4.创建对象
        Student student = (Student) aClass.getConstructor().newInstance();
        System.out.println(student.getClass().getSimpleName()); //Student
        System.out.println(Student.class.getSimpleName());//Student
        //5.获取对象方法
        Method method = aClass.getMethod(methodName);
        System.out.println(method.getName() + "()");//sleep()
        //6.执行方法
        method.invoke(student);//sleep...
    }
}
