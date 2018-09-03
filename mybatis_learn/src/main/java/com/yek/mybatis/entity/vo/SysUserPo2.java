package com.yek.mybatis.entity.vo;

import com.yek.mybatis.entity.SysRole;
import com.yek.mybatis.entity.SysUser;

import java.util.List;

/**
 * Created by yek on 2018-09-01.
 */
public class SysUserPo2 extends SysUser{
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
