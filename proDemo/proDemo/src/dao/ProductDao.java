package dao;

import common.MyPage;
import domain.Product;

public interface ProductDao {
    MyPage<Product> listProduct(MyPage<Product> productMyPage);

    Product selectProductById(String pid);

    Boolean save(Product product);

    Boolean deleteById(String pid);

    Boolean add(Product product);
}
