package druid;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcUtilDru {
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static String  driver = null;

    private static DruidDataSource druidDataSource = null; //数据源
    /**
     * 静态代码块中，只加载一次
     */
    static {
        try {
            druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName(driver);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setInitialSize(10);
            druidDataSource.setMinIdle(1);
            druidDataSource.setMaxActive(20);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱动程序出错！");
        }
    }
}
