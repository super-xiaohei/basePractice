package service;

import common.MyPage;
import domain.Category;

public interface CategoryService {
    MyPage<Category> listCategory(MyPage<Category> categoryMyPage);

    Category selectCategoryById(String cid);

    Boolean save(Category category);

    Boolean deleteById(String cid);

    Boolean add(String cname);
}
