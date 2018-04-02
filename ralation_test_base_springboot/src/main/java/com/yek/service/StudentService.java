package com.yek.service;

import com.yek.entity.Student;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * Created by Administrator on 2018-03-31.
 */

public interface StudentService {
    Page<Student> getStrudentListByPage(Map<String, Object> param);
}
