import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import suncaper.dao.UserDao;
import suncaper.service.Uservice;

/**
 * @author zyq
 * @date 2020/11/6 - 15:25
 */
public class TestSpringDemo1 {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao2 = (UserDao) applicationContext.getBean("UserDao2");
       userDao2.say();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Uservice uservice1 = (Uservice) applicationContext.getBean("userservice1");
        uservice1.say();
    }
}
