package dao;

import common.MyPage;
import domain.Category;

public interface CategoryDao {
    MyPage<Category> listCategory(MyPage<Category> categoryMyPage);

    Category selectCategoryById(String cid);

    Boolean save(Category category);

    Boolean deleteById(String cid);

    Boolean add(String cname);
}
