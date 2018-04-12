package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.UserDao;
import com.blog.pojo.User;
import com.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao UserDao;

	@Override
	public User getUser(User user) {
		return UserDao.getUser(user);
	}
}
