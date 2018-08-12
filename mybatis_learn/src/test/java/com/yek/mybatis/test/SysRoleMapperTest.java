package com.yek.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.yek.mybatis.base.BaseMapperTest;
import com.yek.mybatis.entity.SysUser;
import com.yek.mybatis.entity.SysUserExample;
import com.yek.mybatis.entity.vo.SysRole2User;
import com.yek.mybatis.mapper.SysRoleMapper;
import com.yek.mybatis.mapper.SysUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by yek on 2018-08-12.
 */
public class SysRoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        try {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            List<SysRole2User> sysRole2UserList = sysRoleMapper.selectSysRole2User();
            sysRole2UserList.stream().forEach(sysUser -> System.out.println(JSON.toJSONString(sysUser)));
            Assert.assertNotNull(sysRole2UserList);
            Assert.assertTrue(sysRole2UserList.size()>0);
        } finally {
            sqlSession.close();
        }
    }
}
