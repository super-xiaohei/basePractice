package dao.impl;

import common.MyPage;
import common.utils.JDBCUtil;
import dao.ProductDao;
import domain.Category;
import domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public MyPage<Product> listProduct(MyPage<Product> page) {
        Connection connection = JDBCUtil.getConnection();
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from products where is_del = 0 limit ?,?");
            ps.setInt(1,(page.getPageNo()-1)*page.getPageSize());
            ps.setInt(2,page.getPageSize());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Product product = new Product(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(5),resultSet.getString(6));
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setTotal(getTotal());
        page.setList(list);
        return page;
    }

    @Override
    public Product selectProductById(String pid) {
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from products where pid =? ");
            ps.setString(1,pid);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return new Product(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(5),resultSet.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean save(Product product) {
        Connection connection = JDBCUtil.getConnection();
        int i =0;
        try {
            PreparedStatement ps = connection.prepareStatement("update products set pname =?,price=?,flag=?,category_id =? where pid =? ");
            ps.setString(1,product.getPname());
            ps.setInt(2,product.getPrice());
            ps.setString(3,product.getFlag());
            ps.setString(4,product.getCategory_id());
            ps.setString(5,product.getPid());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    @Override
    public Boolean deleteById(String pid) {
        Connection connection = JDBCUtil.getConnection();
        int i =0;
        try {
            PreparedStatement ps = connection.prepareStatement("update products set is_del= 1 where pid =? ");
            ps.setString(1,pid);
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    @Override
    public Boolean add(Product product) {
        Connection connection = JDBCUtil.getConnection();
        int i =0;
        int i1=0;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from products order by pid DESC");
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                i1 = Integer.parseInt(resultSet.getString(1).substring(1));
            }
            String str = String.format("%03d", i1+1);//如果小于3位左边补0
            PreparedStatement ps1 = connection.prepareStatement("insert into products (pid,pname,is_del,price,flag,category_id) values (?,?,?,?,?,?)");
            ps1.setString(1,"p"+str);
            ps1.setString(2,product.getPname());
            ps1.setString(3,"0");
            ps1.setInt(4,product.getPrice());
            ps1.setString(5,product.getFlag());
            ps1.setString(6,product.getCategory_id());
            i = ps1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    public Integer getTotal(){
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement ps  = connection.prepareStatement("select count(*) from products where is_del = 0");
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
