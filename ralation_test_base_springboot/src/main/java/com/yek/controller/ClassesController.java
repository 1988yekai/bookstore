package com.yek.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018-03-31.
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {
    @RequestMapping("/list")
    @ResponseBody
    public JSONObject getStudentList(){

        return null;
    }
}
