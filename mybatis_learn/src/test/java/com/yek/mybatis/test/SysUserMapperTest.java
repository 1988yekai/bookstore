package com.yek.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.yek.mybatis.base.BaseMapperTest;
import com.yek.mybatis.entity.Country;
import com.yek.mybatis.entity.SysUser;
import com.yek.mybatis.entity.SysUserExample;
import com.yek.mybatis.mapper.CountryMapper;
import com.yek.mybatis.mapper.SysUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by yek on 2018-07-22.
 */
public class SysUserMapperTest extends BaseMapperTest{
    @Test
    public void testSelectByExample(){
        SqlSession sqlSession = getSqlSession();
        try {
            //method 1
//            List<Country> countryList = sqlSession.selectList("selectAll");
            //method 2
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andUserPasswordEqualTo("123456");
            List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
            sysUserList.stream().forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUserExample sysUserExample = new SysUserExample();
            List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
            sysUserList.stream().forEach(sysUser -> System.out.println(JSON.toJSONString(sysUser)));
            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size()>0);
        } finally {
            sqlSession.close();
        }
    }
}
