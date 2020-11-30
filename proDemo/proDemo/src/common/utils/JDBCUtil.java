package common.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
    private static String driverName = null;
    private static String url = null;
    private static String userName = null;
    private static String password = null;
    private static DruidDataSource dds = null;
    static {
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("common/utils/jdbc.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
            dds = new DruidDataSource();
            driverName = pro.getProperty("driverName");
            url = pro.getProperty("url");
            userName = pro.getProperty("userName");
            password = pro.getProperty("password");

            dds.setDriverClassName(driverName);
            dds.setUrl(url);
            dds.setUsername(userName);
            dds.setPassword(password);

            dds.setInitialSize(20);
            dds.setMinIdle(1);
            dds.setMaxActive(50);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //对外提供连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭资源
    public static void close(ResultSet resultSet, Statement sta,Connection con){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(sta!=null){
                sta.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
