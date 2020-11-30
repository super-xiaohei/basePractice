package com;

import com.common.JdbcUtil;

import java.sql.Connection;

public class test1 {
    //测试数据库的连接
    public static void main(String[] args) {
        Connection connection = JdbcUtil.getConnection();
        System.out.println(connection);
    }
}
