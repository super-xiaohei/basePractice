package suncaper.domain.extend;

import suncaper.domain.Student;
import suncaper.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyq
 * @date 2020/11/4 - 15:46
 */
public class ClazzExtend {
    private Teacher teacher;
    private List<Student> students;

    public ClazzExtend(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public ClazzExtend() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



    @Override
    public String toString() {
        return "ClazzExtend{" +
                "teacher=" + teacher +
                ", students=" + students+
                '}';
    }
}
