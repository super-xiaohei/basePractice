package suncaper.dao;

import suncaper.domain.Products;

import java.util.List;

/**
 * @author zyq
 * @date 2020/11/4 - 16:45
 */
public interface ProductsMapper{
    List<Products> selectProductByCid(String cid);
}
