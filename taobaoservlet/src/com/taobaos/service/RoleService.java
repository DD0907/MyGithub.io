package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.Role;

public interface RoleService {
	int insertRole(Role role);

	int updateRole(Role role);

	int deleteRole(Role role);

	// 将status改为0即为删除状态
	int deletestatusRole(Role role);

	// 用Role保存数据
	Role selectRoleByNameS(String name);

	List<Role> selectRoleAll();

	List<Role> selectRoleByName(String name);

}
