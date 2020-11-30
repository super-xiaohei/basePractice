package dao.impl;

import common.Constant;
import common.MyPage;
import common.utils.JDBCUtil;
import dao.UserDao;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User selectByUser(User user) {
        //对数据库元操作
        Connection connection = JDBCUtil.getConnection();

        try {
            PreparedStatement ps  = connection.prepareStatement("select * from user where username = ? and password = ?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()&&resultSet.getInt(4)==1){
                return new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public MyPage<User> listUser(MyPage<User> page) {
        Connection connection = JDBCUtil.getConnection();
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from user where is_del = 0 order by status ,id DESC limit ?,? ");
            ps.setInt(1,(page.getPageNo()-1)*page.getPageSize());
            ps.setInt(2,page.getPageSize());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setTotal(getTotal());
        page.setList(list);
        return page;
    }

    @Override
    public boolean register(User user) {
        Connection connection = JDBCUtil.getConnection();
        int i = 0;
        try {
            PreparedStatement ps  = connection.prepareStatement("insert into user (username,password,url,status) value (?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3, Constant.USER_AVATAR);
            ps.setInt(4, Constant.USER_STATUS);
             i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection = JDBCUtil.getConnection();
        int i = 0;
        try {
            PreparedStatement ps  = connection.prepareStatement("update user set is_del = 1,status = 0 where id = ?");
            ps.setInt(1,id);
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    @Override
    public User selectUserById(int id) {
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement ps  = connection.prepareStatement("select * from user where id = ? limit 1");
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean save(User user) {
        Connection connection = JDBCUtil.getConnection();
        int i = 0;
        try {
            PreparedStatement ps  = connection.prepareStatement("update user set username = ?,password = ?,status = ? where id = ?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getStatus());
            ps.setInt(4,user.getId());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    @Override
    public Boolean updateImg(User user) {
        Connection connection = JDBCUtil.getConnection();
        int i = 0;
        try {
            PreparedStatement ps  = connection.prepareStatement("update user set url = ? where id = ?");
            ps.setString(1,user.getUrl());
            ps.setInt(2,user.getId());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    public Integer getTotal(){
        Connection connection = JDBCUtil.getConnection();

        try {
            PreparedStatement ps  = connection.prepareStatement("select count(*) from user where is_del = 0");
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
