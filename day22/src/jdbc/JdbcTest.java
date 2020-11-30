package jdbc;

import javax.xml.transform.Result;
import java.sql.*;

public class JdbcTest {
    public static void main(String[] args)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/emps", "root", "root");
            //3.获取操作数据库对象
            String sql  = "SELECT E.EMPNO,E.ENAME,(E.SAL+IFNULL(E.COMM,0)) FROM EMP E WHERE (E.SAL+IFNULL(E.COMM,0)) > (SELECT SAL+IFNULL(COMM,0) FROM EMP WHERE ENAME = 'SMITH') ORDER BY (E.SAL+IFNULL(E.COMM,0)) ASC";
            preparedStatement = connection.prepareStatement(sql);
            //4.操作数据库
            resultSet = preparedStatement.executeQuery();
            //5.处理结果集
            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.关闭资源
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
}
