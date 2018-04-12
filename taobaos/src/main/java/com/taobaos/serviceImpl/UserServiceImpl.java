package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.UserMapper;
import com.taobaos.pojo.User;
import com.taobaos.pojo.UserExample;
import com.taobaos.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public int insertUser(User user) {
		int i = userMapper.insertSelective(user);
		return i;
	}

	@Override
	public int updateUser(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(user.getPhone());
		int result = userMapper.updateByExample(user, example);
		return result;
	}

	@Override
	public int deleteUser(User user) {
		int result = userMapper.deleteByPrimaryKey(user.getPhone());
		return result;
	}

	@Override
	public User selectUserByPhone(String phone) {
		User user = userMapper.selectByPrimaryKey(phone);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public List<User> selectUserAll() {
		List<User> ulList = userMapper.selectByExample(null);
		if (ulList != null) {
			return ulList;
		}
		return null;
	}

	@Override
	public List<User> selectUserByPhones(String phone) {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<User> ulList = userMapper.selectByExample(example);
		if (ulList != null) {
			return ulList;
		}
		return null;
	}

}
