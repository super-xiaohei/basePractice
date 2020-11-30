package suncaper.domain;

import java.util.Date;

/**
 * @author zyq
 * @date 2020/11/3 - 9:55
 */
public class User {
    private Integer id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public User(String username, String sex, Date birthday, String address, String pwd) {
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.pwd = pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
    }

    public User(String username, String sex, Date birthday, String address) {
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
