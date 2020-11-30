package com.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String username = null;
    private static String password = null;
    private static String url = null;
    static {
        //在这里获取url，username。。。并注册驱动
        Properties properties = new Properties();
        //JdbcUtil jdbcUtil = new JdbcUtil();
        //InputStream resourceAsStream = jdbcUtil.getClass().getClassLoader().getResourceAsStream("suncaper/admin/common/jdbc.properties"); //反射原理
        InputStream resourceAsStream = JdbcUtil.class.getClassLoader().getResourceAsStream("com/common/jdbc.properties");
        try {
            properties.load(resourceAsStream);
            username = properties.getProperty("username");
            url = properties.getProperty("url");
            password = properties.getProperty("password");
            Class.forName(properties.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
