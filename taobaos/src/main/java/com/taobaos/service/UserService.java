package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.User;

public interface UserService {
	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(User user);

	User selectUserByPhone(String phone);
	
	List<User> selectUserByPhones(String phone);

	List<User> selectUserAll();
}
