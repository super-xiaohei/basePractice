import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import suncaper.dao.ProductsMapper;
import suncaper.domain.Products;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zyq
 * @date 2020/11/4 - 17:40
 */
public class TestMybatis3 {
    public static void main(String[] args) throws SQLException, IOException {
        InputStream resourceAsStream = TestMybatis3.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.getConnection().setAutoCommit(true);

        ProductsMapper productsMapper = sqlSession.getMapper(ProductsMapper.class);
        List<Products> products = productsMapper.selectProductByCid("c001");
        for (Products product : products) {
            System.out.println(product);
        }

        sqlSession.close();
        resourceAsStream.close();
    }
}
