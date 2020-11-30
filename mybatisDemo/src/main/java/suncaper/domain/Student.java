package suncaper.domain;

/**
 * @author zyq
 * @date 2020/11/4 - 16:54
 */
public class Student {
    private Integer sid;
    private String sname;
    private Integer cid;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer cid) {
        this.sid = sid;
        this.sname = sname;
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", cid=" + cid +
                '}';
    }
}
