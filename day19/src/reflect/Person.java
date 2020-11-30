package reflect;

public class Person {
    private String name;
    private String sex;

    public Person() {
        System.out.println("默认无参构造");
    }

    public Person(String name, String sex) {
        System.out.println("两个参数的构造方法");
        this.name = name;
        this.sex = sex;
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
}
