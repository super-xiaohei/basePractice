package suncaper;

import org.springframework.stereotype.Repository;

import java.beans.PersistenceDelegate;
import java.util.List;
import java.util.Map;

@Repository
public class Teacher1 {
    private Integer id;
    private String name;
    private Integer age;
    private List<String> list;
    private List<Student1> student1List;
    private Map<String,Student1> map;

    public Teacher1(Integer id, String name, Integer age, List<String> list, List<Student1> student1List, Map<String, Student1> map, Student1 student1) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.list = list;
        this.student1List = student1List;
        this.map = map;
        this.student1 = student1;
    }

    public List<String> getList() {
        return list;
    }

    public Teacher1(Map<String, Student1> map) {
        this.map = map;
    }

    public Map<String, Student1> getMap() {
        return map;
    }

    public void setMap(Map<String, Student1> map) {
        this.map = map;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Student1> getStudent1List() {
        return student1List;
    }

    public void setStudent1List(List<Student1> student1List) {
        this.student1List = student1List;
    }

    private Student1 student1;

    public Student1 getStudent1() {
        return student1;
    }

    public Teacher1(Student1 student1) {
        this.student1 = student1;
    }

    public Teacher1(Integer id, String name, Integer age, Student1 student1) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.student1 = student1;
    }

    public void setStudent1(Student1 student1) {
        this.student1 = student1;
    }

    public Integer getId() {
        return id;
    }

    public Teacher1(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Teacher1() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void sayT(){
        System.out.println("我是老师");
    }
}
