package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    @Test
    public static void main(String[] args) throws Exception {
        //拿到类对象的Class
        String typeName = "reflect.Person"; //根据字符串的内容创建相应的对象
        Class<?> aClass = Class.forName("reflect.Person");
        String name = "小黑";
        String sex = "男";
        //先拿到构造器
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class);
        //再new实例
        Person person = (Person) constructor.newInstance(name, sex);
        System.out.println(person.getName());
        System.out.println(person.getSex());


        Field fieldName = aClass.getDeclaredField("name"); //只能那个指定的一个成员变量
        fieldName.setAccessible(true); //暴力访问,私有的成员变量不使用带Declared的方法也可以访问,对其进行set
        fieldName.set(person,"彭于晏");
        System.out.println(person.getName() + ":" + person.getSex());
        Field fieldSex = aClass.getField("sex"); //不带Declared的方法只能拿到公开的成员变量，但是如果有第25行代码，那么此方法私有的成员变量也可以访问fi
        fieldSex.setAccessible(true);
        fieldSex.set(person,"女");

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + "()");
        }
        String simpleName = aClass.getSimpleName();
        System.out.println(aClass);//完整限定包名
        System.out.println(simpleName);//获取简单类名
    }
}
