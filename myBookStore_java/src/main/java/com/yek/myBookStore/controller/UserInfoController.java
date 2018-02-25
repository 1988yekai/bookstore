package com.yek.myBookStore.controller;

import com.alibaba.fastjson.JSONObject;
import com.yek.myBookStore.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    @ResponseBody
    public JSONObject userInfo(){
        JSONObject object = new JSONObject();
//        object.put("content", userInfoService.findAllUserInfo());
        object.put("content", userInfoService.findAllUserInfoByPage());
        object.put("code", "0000");
        object.put("state", true);
        object.put("msg", "查询成功！");

        return object;
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    @ResponseBody
    public String userInfoAdd(){
        return "userInfoAdd";
    }
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
}
