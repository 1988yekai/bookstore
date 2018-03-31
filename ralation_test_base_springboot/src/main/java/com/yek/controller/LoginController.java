package com.yek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018-03-31.
 */
@Controller
public class LoginController {
    @RequestMapping("/")
    public String index() {
        return "/index";
    }
}
