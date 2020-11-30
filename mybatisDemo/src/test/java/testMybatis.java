import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import suncaper.dao.UserMapper;
import suncaper.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zyq
 * @date 2020/11/3 - 10:42
 */
public class testMybatis {

    public static void main(String[] args) throws SQLException, IOException, ParseException {

        InputStream resourceAsStream = testMybatis.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream); //构建者模式
        SqlSession sqlSession = sqlSessionFactory.openSession();//工厂模式

        //UserDao userDao = new UserDaoImpl();
        //sqlSession.getMapper(UserMapper)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);//代理模式
//        User user = userMapper.selectUserById(1);
//        System.out.println(user);


        List<User> list = userMapper.selectByName("张");
        System.out.println(list);

        Connection connection = sqlSession.getConnection();
        connection.setAutoCommit(true); //设置sqlSession的自动提交
//        List<User> users = userMapper.selectUserByAddr("上海");
//        System.out.println(users);
//        for (User user1 : users) {
//            System.out.println(user1);
//        }
//        int i = userMapper.deleteById(2,"上海");
//        System.out.println(i);


//        String birthday = "2018-07-10";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date birthday1 = simpleDateFormat.parse(birthday);
//
//            int i = userMapper.inserUser(new User("小蓝","1",birthday1,"成都"));
//            System.out.println(i);
//            sqlSession.commit();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        User user = new User();
//        user.setId(1);
//        user.setAddress("北京");
//        User user1 = userMapper.selectByUser(user);
//        System.out.println(user1);
//        System.out.println(user1.getId());

        //String LikeName = "王";
        /*List<User> userList = userMapper.selectByLikeName();
        for (User user : userList) {
            System.out.println(user);
        }*/


//        List<User> userList = userDao.selectUserByAddr("上海", sqlSession);
//        for (User user1 : userList) {
//            System.out.println(user1);
//        }

        //返回map集合
        /*Map<Integer, User> userMap = userMapper.selectAllMapUser();
        Set<Integer> key = userMap.keySet();
        for (Integer k : key) {
            System.out.println(k + "------>" + userMap.get(k));
        }*/

        //返回单个的map
//        Map<String,Object> oneMapUser = userMapper.selectOneMapUser(1);
//        System.out.println(oneMapUser);

        //返回map形式的数据行
//        List<Map<String,Object>> mapList = userMapper.selectAllMapCol();
//        for (Map<String, Object> objectMap : mapList) {
//            Set<String> strings = objectMap.keySet();
//            for (String string : strings) {
//                System.out.println(string + "------->" + objectMap.get(string) + "\t");
//            }
//            System.out.println();
//        }
        //动态sql多条件查询
//        User user = new User();
//        user.setSex("1");
//        user.setId(1);
//        user.setPwd("123456");
//        List<User> userList = userMapper.selelctBySome(new User());
//        for (User user1 : userList) {
//            System.out.println(user1);
//        }
        //动态sql批量删除
//        List<Integer> idList = Arrays.asList(5, 33);
//        int i = userMapper.deleteByIds(idList);
//        System.out.println(i);
//
//        sqlSession.close();
//        resourceAsStream.close();


        //动态sql批量插入
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-06");
        Date parse1 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-07");
        Date parse2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-08");
        List<User> userList = Arrays.asList(new User("aa","1",parse,"aa","123"),new User("bb","1",parse1,"bb","123"),new User("cc","0",parse2,"cc","123"));
        int i = userMapper.inserUsers(userList);
        System.out.println(i);
    }


}
