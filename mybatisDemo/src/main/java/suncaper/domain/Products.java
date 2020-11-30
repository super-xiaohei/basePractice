package suncaper.domain;

import suncaper.domain.extend.ProductsExtend;

/**
 * @author zyq
 * @date 2020/11/4 - 16:38
 */
public class Products extends ProductsExtend {
    private String pid;
    private String pname;
    private Integer price;
    private String flag;
    private String category_id;

    public Products() {
    }

    public Products(String pid, String pname, Integer price, String flag, String category_id) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.flag = flag;
        this.category_id = category_id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", flag='" + flag + '\'' +
                ", category_id='" + category_id + '\'' +
                ", category=" + super.toString() +
                '}';
    }
}
