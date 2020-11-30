package suncaper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class Student1 {
    private String major;
    //@Autowired //自动装配byType （required = false）表示有对象就装上吗，没有就返回一个null
    @Resource //也是自动装配 byName
    private Teacher1 teacher1;

    public Student1(String major) {
        this.major = major;
    }

    public Teacher1 getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(Teacher1 teacher1) {
        this.teacher1 = teacher1;
    }

    public Student1() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void sayS(){
        System.out.println("我是学生");
    }
}
