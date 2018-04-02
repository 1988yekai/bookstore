package com.yek.service.impl;

import com.alibaba.fastjson.JSON;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.yek.entity.QStudent;
import com.yek.entity.Student;
import com.yek.repository.StudentRepository;
import com.yek.service.StudentService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-31.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public PageImpl getStrudentListByPage(Map<String, Object> param) {
        System.out.println(param);
//        PageRequest page = new PageRequest();
        int pageNumber = MapUtils.getInteger(param, "page") == null ? 1:MapUtils.getInteger(param, "page");
        int pageSize = MapUtils.getInteger(param, "rows") == null ? 10:MapUtils.getInteger(param, "rows");
        QPageRequest page = new QPageRequest(pageNumber - 1, pageSize);
//        PageRequest page = new PageRequest(pageNumber - 1,pageSize);
        PageImpl<Student> studentPage = studentRepository.findAll(page);

        BooleanExpression s1 = QStudent.student.name.eq("s1");
        Student one = studentRepository.findOne(s1);
        one.setClasses(null);
        one.setTeacherList(null);
        System.out.println(JSON.toJSON(one));
        return studentPage;
    }
}
