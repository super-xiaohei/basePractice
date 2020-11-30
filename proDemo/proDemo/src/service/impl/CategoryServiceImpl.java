package service.impl;

import common.MyPage;
import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public MyPage<Category> listCategory(MyPage<Category> categoryMyPage) {
        return categoryDao.listCategory(categoryMyPage);
    }

    @Override
    public Category selectCategoryById(String cid) {
        return categoryDao.selectCategoryById(cid);
    }

    @Override
    public Boolean save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Boolean deleteById(String cid) {
        return categoryDao.deleteById(cid);
    }

    @Override
    public Boolean add(String cname) {
        return categoryDao.add(cname);
    }
}
