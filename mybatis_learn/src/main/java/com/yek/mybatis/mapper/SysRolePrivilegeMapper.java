package com.yek.mybatis.mapper;

import com.yek.mybatis.entity.SysRolePrivilege;
import com.yek.mybatis.entity.SysRolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePrivilegeMapper {
    long countByExample(SysRolePrivilegeExample example);

    int deleteByExample(SysRolePrivilegeExample example);

    int insert(SysRolePrivilege record);

    int insertSelective(SysRolePrivilege record);

    List<SysRolePrivilege> selectByExample(SysRolePrivilegeExample example);

    int updateByExampleSelective(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    int updateByExample(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);
}