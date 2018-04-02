package com.yek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 学生类
 * Created by Administrator on 2018-03-31.
 */
@Entity
@JsonIgnoreProperties(value = { "student"})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long sid;//学生id

    @Column
    private String name;
    @Column
    private int age;

    //学生到班级 多对一
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")// 在多端（从表的外键）添加外键字段指向一端（主表的主键）的主键字
    private Classes classes;

    //学生到老师 多对多
    @ManyToMany(fetch = FetchType.EAGER) // 立即从数据库中进行加载数据
    @JoinTable(name = "TeachersAndStudent",
            schema = "student",
            joinColumns = { @JoinColumn(name = "sid") }, inverseJoinColumns = {@JoinColumn(name = "tid") })
    private Set<Teacher> teacherList = new LinkedHashSet<>();

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Set<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(Set<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classes=" + classes +
                ", teacherList=" + teacherList +
                '}';
    }
}
