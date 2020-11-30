package domain;

public class Product {
    private String pid;
    private String pname;
    private Integer price;
    private String is_del;
    private String flag;
    private String category_id;

    public Product() {
    }

    public Product(String pid, String pname, Integer price, String flag, String category_id) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.flag = flag;
        this.category_id = category_id;
    }

    public Product(String pname, Integer price, String flag, String category_id) {
        this.pname = pname;
        this.price = price;
        this.flag = flag;
        this.category_id = category_id;
    }

    public Product(String pid, String pname, Integer price, String is_del, String flag, String category_id) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.is_del = is_del;
        this.flag = flag;
        this.category_id = category_id;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
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
        return "{" +
                "\"pid\":\"" + pid + '\"' +
                ", \"pname\":\"" + pname + '\"' +
                ", \"price\":" + price +
                ", \"flag\":\"" + flag + '\"' +
                ", \"category_id\":\"" + category_id + '\"' +
                '}';
    }
}
