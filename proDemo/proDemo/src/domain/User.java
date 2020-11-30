package domain;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private Integer is_del;
    private String url;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, String url) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public User(Integer id, String username, String password, Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public User(Integer id, String username, String password, Integer status, Integer is_del, String url) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.is_del = is_del;
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIs_del() {
        return is_del;
    }

    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"username\":\"" + username + '\"' +
                ", \"password\":\"" + password + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"is_del\":\"" + is_del + '\"' +
                ", \"url\":\"" + url + '\"' +
                '}';
    }
}
