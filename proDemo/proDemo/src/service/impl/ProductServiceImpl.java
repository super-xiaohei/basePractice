package service.impl;

import common.MyPage;
import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import domain.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public MyPage<Product> listProduct(MyPage<Product> productMyPage) {
        return productDao.listProduct(productMyPage);
    }

    @Override
    public Product selectProductById(String pid) {
        return productDao.selectProductById(pid);
    }

    @Override
    public Boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Boolean deleteById(String pid) {
        return productDao.deleteById(pid);
    }

    @Override
    public Boolean add(Product product) {
        return productDao.add(product);
    }
}
