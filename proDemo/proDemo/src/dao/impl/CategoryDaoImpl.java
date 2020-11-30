package dao.impl;

import common.MyPage;
import common.utils.JDBCUtil;
import dao.CategoryDao;
import domain.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {


    @Override
    public MyPage<Category> listCategory(MyPage<Category> page) {
        Connection connection = JDBCUtil.getConnection();
        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from category where is_del = 0 limit ?,? ");
            ps.setInt(1,(page.getPageNo()-1)*page.getPageSize());
            ps.setInt(2,page.getPageSize());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Category category = new Category(resultSet.getString(1),resultSet.getString(2));
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        page.setTotal(getTotal());
        page.setList(list);
        return page;
    }

    @Override
    public Category selectCategoryById(String cid) {
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from category where cid =? ");
            ps.setString(1,cid);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return new Category(resultSet.getString(1),resultSet.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean save(Category category) {
        Connection connection = JDBCUtil.getConnection();
        int i =0;
        try {
            PreparedStatement ps = connection.prepareStatement("update category set cname =? where cid =? ");
            ps.setString(1,category.getCname());
            ps.setString(2,category.getCid());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    @Override
    public Boolean deleteById(String cid) {
        Connection connection = JDBCUtil.getConnection();
        int i =0;
        try {
            PreparedStatement ps1 = connection.prepareStatement("select * from products where category_id =? ");
            ps1.setString(1,cid);
            ResultSet resultSet = ps1.executeQuery();
            if (resultSet.next()){
                return false;
            }else {
                PreparedStatement ps = connection.prepareStatement("update category set is_del = 1 where cid =? ");
                ps.setString(1,cid);
                i = ps.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    @Override
    public Boolean add(String cname) {
        Connection connection = JDBCUtil.getConnection();
        int i =0;
        int i1=0;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from category order by cid DESC");
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                 i1 = Integer.parseInt(resultSet.getString(1).substring(1));
            }
            String str = String.format("%03d", i1+1);//如果小于3位左边补0
            PreparedStatement ps1 = connection.prepareStatement("insert into category (cid,cname,is_del) values (?,?,?)");
            ps1.setString(1,"c"+str);
            ps1.setString(2,cname);
            ps1.setString(3,"0");
            i = ps1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i!=0;
    }

    public Integer getTotal(){
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement ps  = connection.prepareStatement("select count(*) from category where is_del = 0");
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
