package com.yek.mybatis.entity.vo;

import com.yek.mybatis.entity.SysRole;
import com.yek.mybatis.entity.SysUser;

/**
 * Created by yek on 2018-09-01.
 */
public class SysUserPo1 extends SysUser{
    private SysRole role;

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }
}
