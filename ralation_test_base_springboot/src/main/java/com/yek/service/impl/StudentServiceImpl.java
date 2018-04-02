package com.yek.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.yek.entity.QStudent;
import com.yek.entity.Student;
import com.yek.repository.StudentRepository;
import com.yek.service.StudentService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Administrator on 2018-03-31.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> getStrudentListByPage(Map<String, Object> param) {
        System.out.println(param);

        BooleanExpression s1 = QStudent.student.name.eq("小东");
        Optional<Student> studentOptional = studentRepository.findOne(s1);
        Student one = studentOptional.isPresent() ? studentOptional.get() : null;
        System.out.println(one);

//        PageRequest page = new PageRequest();
        int pageNumber = MapUtils.getInteger(param, "page") == null ? 1 : MapUtils.getInteger(param, "page");
        int pageSize = MapUtils.getInteger(param, "rows") == null ? 10 : MapUtils.getInteger(param, "rows");
        QSort sort = new QSort(QStudent.student.name.asc());
//        sort.and(QStudent.student.sid.desc());//添加下一个排序条件
        QPageRequest page = new QPageRequest(pageNumber - 1, pageSize, sort);
//        PageRequest page = new PageRequest(pageNumber - 1,pageSize);
        Page<Student> studentPage = studentRepository.findAll(page);


        return studentPage;
    }
}
