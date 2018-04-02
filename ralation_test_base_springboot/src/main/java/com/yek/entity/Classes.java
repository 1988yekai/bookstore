package com.yek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 班级类
 * Created by Administrator on 2018-03-31.
 */
@Entity
@JsonIgnoreProperties(value = { "students"})
public class Classes implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long cid;// 班级id

    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classes",fetch = FetchType.EAGER) //mappedBy = "one" 表示one是一对多管理的被维护端， 既当添加many时顺带添加一个one
    private Set<Student> students = new LinkedHashSet<>();
    //班级到学生 1对多
//    @JsonBackReference(value="user-movement")//阻止2次以上的循环调用
//    @JsonBackReference//阻止2次以上的循环调用
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }*/
}
