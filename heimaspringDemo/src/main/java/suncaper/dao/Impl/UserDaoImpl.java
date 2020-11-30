package suncaper.dao.Impl;

import jdk.nashorn.internal.objects.annotations.Property;
import suncaper.dao.UserDao;
import suncaper.domain.User;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author zyq
 * @date 2020/11/6 - 15:21
 */
public class UserDaoImpl implements UserDao {
    private List<String> list;
    private Map<String, User> map;
    private Properties properties;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建了...");
    }

    public void say() {
        System.out.println("今天是个好日子，哈哈......");
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);
    }
}
