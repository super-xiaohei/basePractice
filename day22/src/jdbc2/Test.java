package jdbc2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        //注册驱动 + 获取连接
        Connection connection = JdbcUtil.getConnection();
        try {
           /* preparedStatement = connection.prepareStatement("update emp set ENAME = ? where ENAME = ?");
            preparedStatement.setString(1,"smith1");
            preparedStatement.setString(2,"smith3");*/
           preparedStatement = connection.prepareStatement("insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,"7718");
           preparedStatement.setString(2,"hello");
           preparedStatement.setString(3,"world");
           preparedStatement.setInt(4,7839);
           preparedStatement.setDate(5, Date.valueOf("2005-05-06"));
           preparedStatement.setDouble(6,12000);
           preparedStatement.setDouble(7,2000);
           preparedStatement.setInt(8,40);
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(connection,preparedStatement,null);
    }
}
