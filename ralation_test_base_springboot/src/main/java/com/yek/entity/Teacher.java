package com.yek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 教师类
 * Created by Administrator on 2018-03-31.
 */
@Entity
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long tid;//教师id
    @Column
    private String name;

    //老师到学生 多对多
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "teacherList",fetch = FetchType.LAZY) // student端管理
    private Set<Student> studentList = new HashSet<>();

    @JsonIgnore
    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
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
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
