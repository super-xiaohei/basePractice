package suncaper.domain;

import suncaper.domain.extend.ClazzExtend;

import java.io.Serializable;

/**
 * @author zyq
 * @date 2020/11/4 - 15:23
 */
public class Clazz extends ClazzExtend implements Serializable {
    private Integer id;
    private String name;
    private Integer tid;

    public Clazz() {
    }

    public Clazz(Integer id, String name, Integer tid) {
        this.id = id;
        this.name = name;
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                ", " + super.toString() +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

}
