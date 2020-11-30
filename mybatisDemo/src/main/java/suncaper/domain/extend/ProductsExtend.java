package suncaper.domain.extend;

import suncaper.domain.Category;

/**
 * @author zyq
 * @date 2020/11/4 - 18:22
 */
public class ProductsExtend {
    private Category category;

    public ProductsExtend() {
    }

    public ProductsExtend(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductsExtend{" +
                "category=" + category.getCname() +
                '}';
    }
}
