package com.yek.controller;

import com.alibaba.fastjson.JSONObject;
import com.yek.entity.Student;
import com.yek.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-31.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    @ResponseBody
    public JSONObject getStudentList( @RequestParam Map<String, Object> paramMap){
        JSONObject object = new JSONObject();
        PageImpl studentsByPage = studentService.getStrudentListByPage(paramMap);
        object.put("total", studentsByPage.getTotalElements());
        object.put("rows",studentsByPage.getContent());

        return object;
    }
}
