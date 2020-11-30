package suncaper.service.Impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import suncaper.dao.UserDao;
import suncaper.service.Uservice;

/**
 * @author zyq
 * @date 2020/11/6 - 15:51
 */
public class UserviceImpl implements Uservice {
    public void say() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) applicationContext.getBean("UserDao1");
        userDao1.say();
    }
}
