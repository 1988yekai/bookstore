package com.yek.mybatis.entity.vo;

import com.yek.mybatis.entity.SysRole;
import com.yek.mybatis.entity.SysUser;

/**
 * Created by yek on 2018-08-12.
 */
public class SysRole2User extends SysRole {
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
