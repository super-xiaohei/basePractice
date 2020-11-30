package suncaper.admin.dao;

import suncaper.admin.common.JdbcUtil;
import suncaper.admin.entity.Category;
import suncaper.admin.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //增加用户。。。。
    public int insert(User user) {
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into admin_user(name,pwd) values (?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPwd());
           return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //查询用户
    public User selectByUser(User user) {
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admin_user where name = ? and pwd = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPwd());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String pwd = resultSet.getString(3);
                return new User(id, name, pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updatePwd(User currentLoginUser) {
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update admin_user set pwd = ? where name = ?");
            preparedStatement.setString(1, currentLoginUser.getPwd());
            preparedStatement.setString(2,currentLoginUser.getName());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insertCategory(Category category) {
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into category(cid,cname) values(?,?)");
            preparedStatement.setString(1,category.getCid());
            preparedStatement.setString(2,category.getCname());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
