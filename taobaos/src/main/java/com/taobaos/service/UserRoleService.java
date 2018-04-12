package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.UserRole;

public interface UserRoleService {
	int insertUserRole(UserRole userRole);

	int updateUserRole(UserRole userRole);

	int deleteUserRole(UserRole userRole);

	List<UserRole> selectUserRoleByPhone(String phone);

	List<UserRole> selectUserRoleAll();
}
