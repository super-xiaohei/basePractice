package suncaper.domain;

/**
 * @author zyq
 * @date 2020/11/4 - 15:26
 */
public class Teacher {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Teacher() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
