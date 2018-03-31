package com.yek.service.impl;

import com.yek.entity.Student;
import com.yek.repository.StudentRepository;
import com.yek.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Student> getStrudentListByPage(Map<String, Object> param) {
        System.out.println(param);
        return studentRepository.findAll();
    }
}
