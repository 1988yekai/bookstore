package com.yek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 班级类
 * Created by Administrator on 2018-03-31.
 */
@Entity
public class Classes implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long cid;// 班级id

    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classes",fetch = FetchType.LAZY) //mappedBy = "one" 表示one是一对多管理的被维护端， 既当添加many时顺带添加一个one
    private Set<Student> studentList = new HashSet<>();
    //班级到学生 1对多
    @JsonIgnore
    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
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
                ", studentList=" + studentList +
                '}';
    }*/
}
