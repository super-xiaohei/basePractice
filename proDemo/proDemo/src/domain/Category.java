package domain;

public class Category {
    private String cid;
    private String cname;
    private String is_del;

    public Category() {
    }

    public Category(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Category(String cid, String cname, String is_del) {
        this.cid = cid;
        this.cname = cname;
        this.is_del = is_del;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "{" +
                "\"cid\":\"" + cid + '\"' +
                ", \"cname\":\"" + cname + '\"' +
                '}';
    }
}
