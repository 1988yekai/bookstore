package com.yek.mybatis.mapper;

import com.yek.mybatis.entity.SysUser;
import com.yek.mybatis.entity.SysUserExample;
import java.util.List;

import com.yek.mybatis.entity.vo.SysUserPo1;
import com.yek.mybatis.entity.vo.SysUserPo2;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUserPo1 selectUserAndRoleById(Integer id);

    List<SysUserPo2> selectAllUserAndRole();
}