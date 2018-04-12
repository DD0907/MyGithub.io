package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.Permission;

public interface PermissionService {
	int insertPermission(Permission permission);

	int updatePermission(Permission permission);

	int deletePermission(Permission permission);

	// 将status改为0即为删除状态
	int deletestatusPermission(Permission permission);

	// 用Permission保存数据
	Permission selectPermissionByName(String name);

	List<Permission> selectPermissionAll();


}
