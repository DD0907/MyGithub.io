package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.RolePermission;

public interface RolePermissionService {
	int insertRolePermission(RolePermission rolePermission);

	int updateRolePermission(RolePermission rolePermission);

	int deleteRolePermission(RolePermission rolePermission);

	List<RolePermission> selectRolePermissionByRoleId(Integer roleId);

	List<RolePermission> selectRolePermissionAll();
}
