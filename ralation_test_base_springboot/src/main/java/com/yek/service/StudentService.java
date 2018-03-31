package com.yek.service;

import com.yek.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-31.
 */

public interface StudentService {
    List<Student> getStrudentListByPage(Map<String, Object> param);
}
