package com.yek.myBookStore.controller;

import com.alibaba.fastjson.JSONObject;
import com.yek.myBookStore.common.ShiroUtils;
import com.yek.myBookStore.entity.UserInfo;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录控制器
 * Created by yek on 2018/2/16 0016.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 是否登录
     *
     * @return
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public JSONObject isLogin() {
        JSONObject object = new JSONObject();
        object.put("isLogin", ShiroUtils.isLogin());
        if (ShiroUtils.isLogin()) {
            object.put("msg", "已登录");
            object.put("code", "0000");
        } else {
            object.put("msg", "末登录");
            object.put("code", "0002");
        }
        return object;
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public JSONObject doLogin(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
        String username = MapUtils.getString(paramMap, "username");
        String password = MapUtils.getString(paramMap, "password");
        System.out.println("username: " + username + "; password: " + password);
        JSONObject obj = new JSONObject();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) /*||  StringUtils.isBlank(captcha)*/) {
            obj.put("code", "0001");
            obj.put("state", false);
            obj.put("msg", "用户名或密码不能为空！");
            return obj;
        }
        System.out.println("LoginController.login");
        // 登录失败从request中获取shiro处理的异常信息
        // shiroLoginFailure:就是shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -->帐号不存在：");
                msg = "UnknownAccountException -->帐号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        } else {
            try {
                Subject subject = ShiroUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                subject.login(token);
                // 登录成功
                obj.put("msg", "登录成功");
                obj.put("code", "0002");
                obj.put("state", true);
                return obj;
            } catch (AuthenticationException e) {
                e.printStackTrace();
                // 登录失败
                msg = "账户验证失败：用户名或密码错误！";
            }
        }
        obj.put("msg", msg);
        obj.put("code", "0001");
        obj.put("state", false);
        return obj;
    }


    @RequestMapping("/isNotAuth")
    @ResponseBody
    public JSONObject isNotAuth() {
        JSONObject obj = new JSONObject();
        obj.put("code", 403);
        obj.put("msg", "you have no authc!");
        return obj;
    }

    /**
     * 退出系统
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public JSONObject logout() {
        JSONObject obj = new JSONObject();
        String msg = null;
        try {
            ShiroUtils.logout();
            msg = "注销成功";
            obj.put("code", "0000");
            obj.put("state", true);

        } catch (Exception e) {
            e.printStackTrace();
            obj.put("code", "0001");
            obj.put("state", false);
            msg = "注销成功失败，" + e.getMessage();
        }
        obj.put("msg", msg);
        return obj;
    }
}
