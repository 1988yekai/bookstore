package com.yek.myBookStore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/16 0016.
 */
@RestController
@RequestMapping("/Login")
public class Login {
    @RequestMapping("/isLogin")
    @ResponseBody
    public JSONObject isLogin(@RequestParam String username,@RequestParam String password) {
        JSONObject obj = new JSONObject();
        if ("yek".equals(username) && "yek".equals(password)) {
            obj.put("login", "ok");
        } else {
            obj.put("login","no");
        }
        return obj;
    }
}
