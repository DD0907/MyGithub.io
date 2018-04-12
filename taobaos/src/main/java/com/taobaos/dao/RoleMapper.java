package com.taobaos.dao;

import com.taobaos.pojo.Role;
import com.taobaos.pojo.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
	long countByExample(RoleExample example);

	int deleteByExample(RoleExample example);

	// 将status改为0即为删除状态
	int deletestatusRole(Role role);

	int deleteByPrimaryKey(Integer id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	//用Role保存数据
	Role selectRoleByNameS(String name);
}