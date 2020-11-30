package homework1;

import java.util.Date;

public class Emps {
    private String no;
    private String name;
    private String sex;
    private int age;
    private String birthday;

    public Emps() {}

    public Emps(String no, String name, String sex, int age, String birthday) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = (no != null?no.trim():null); //其他类似
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  no
                + "," +name
                + "," + sex
                + "," + age
                + "," + birthday;
    }
}
