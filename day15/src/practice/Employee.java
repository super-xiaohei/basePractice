package practice;

import org.junit.Test;

import java.io.Serializable;

/**
 * 序列化
 */
public class Employee implements Serializable {
    private String name;
    private String address;
    private transient int age; //transient瞬态修饰成员，不会被序列化

    public Employee() {
    }

    public Employee(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addressCheck(){
        System.out.println("address check : " + name + " - - " + address);
    }

}
