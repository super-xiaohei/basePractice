package suncaper;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-setting.xml");
        System.out.println(classPathXmlApplicationContext);
        /*//三种方式
        //Teacher1 teacher1 = (Teacher1)classPathXmlApplicationContext.getBean("t1");
        //Teacher1 bean = classPathXmlApplicationContext.getBean(Teacher1.class);
        Teacher1 teacher11 = classPathXmlApplicationContext.getBean("t7", Teacher1.class);
       // teacher1.sayT();
        //bean.sayT();
        teacher11.sayT();
        System.out.println(teacher11.getName() + ":" + teacher11.getAge() + ":" + teacher11.getId());
        //System.out.println(teacher11.getStudent1List().get());
        System.out.println(teacher11.getList());
        System.out.println(teacher11.getMap().entrySet());*/

        /*MyDrive myDrive = classPathXmlApplicationContext.getBean("myDrive2", MyDrive.class);
        System.out.println(myDrive);*/

        Student1 student1 = (Student1)classPathXmlApplicationContext.getBean("student1");
        System.out.println(student1);
        System.out.println(student1.getTeacher1());
    }
}
