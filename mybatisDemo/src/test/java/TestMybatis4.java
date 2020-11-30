import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import suncaper.dao.ProductMapper;
import suncaper.domain.Product;
import suncaper.domain.ProductExample;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zyq
 * @date 2020/11/5 - 10:49
 */
public class TestMybatis4 {
    public static void main(String[] args) throws SQLException {
        InputStream resourceAsStream = TestMybatis3.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.getConnection().setAutoCommit(true);

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        //查询id为2的产品
//        Product product = productMapper.selectByPrimaryKey(2);
//        System.out.println(product);

        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
//        //使用productExample查询CategoryId为“服饰”的产品
//        criteria.andCategoryIdEqualTo("服饰");
//        List<Product> products = productMapper.selectByExample(productExample);
//        for (Product product : products) {
//            System.out.println(product);
//        }



        //使用productExample查询CategoryId为“服饰”并且id = 6的产品
//        criteria.andCategoryIdEqualTo("服饰").andIdEqualTo(6);
//        List<Product> products = productMapper.selectByExample(productExample);
//        for (Product product : products) {
//            System.out.println(product);
//        }

        //自己写的方法计算总条数
//        int count = productMapper.count();
//        System.out.println(count);

        Page<Object> objects = PageHelper.startPage(1, 10);
        List<Product> products = productMapper.selectByExample(null);
        PageInfo<Product> productPageInfo = new PageInfo<>(products);
        System.out.println(productPageInfo);
    }
}
