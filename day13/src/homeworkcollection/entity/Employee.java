package homeworkcollection.entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private String empNo;
    private String name;
    private String sex;
    private int age;
    private String hireDate;

    public Employee() {

    }

    public Employee(String empNo, String name, String sex, int age, String hireDate) {
        this.empNo = empNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hireDate = hireDate;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = (empNo != null?empNo.trim():null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null?name.trim():null);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = (sex != null?sex.trim():null);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = (hireDate != null?hireDate.trim():null);
    }

    @Override
    public String toString() {
        return "" + empNo + '\t' + name +'\t'+ sex + '\t' + age + '\t'+ hireDate  ;
    }
}
