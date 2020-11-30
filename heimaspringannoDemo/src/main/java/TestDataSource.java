import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zyq
 * @date 2020/11/6 - 18:01
 */
public class TestDataSource {

    @Test
    //手动测试druid数据源
    public void test1() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/emps");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //测试spring容器产生数据源(druid) ,其他的还有c3P0等，都差不多
    @Test
    public void test2() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jdbc.properties");
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
