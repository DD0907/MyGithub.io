package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.UserMapper;
import com.taobaos.pojo.User;
import com.taobaos.pojo.UserExample;
import com.taobaos.service.UserService;
import com.taobaos.util.DBUtil;

public class UserServiceImpl implements UserService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertUser(User user) {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int i = userMapper.insert(user);
		session.commit();
		return i;
	}

	@Override
	public int updateUser(User user) {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(user.getPhone());
		int result = userMapper.updateByExample(user, example);
		session.commit();
		return result;
	}

	@Override
	public int deleteUser(User user) {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int result = userMapper.deleteByPrimaryKey(user.getPhone());
		session.commit();
		return result;
	}

	@Override
	public User selectUserByPhone(String phone) {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(phone);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public List<User> selectUserAll() {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> ulList = userMapper.selectByExample(null);
		if (ulList != null) {
			return ulList;
		}
		return null;
	}

	@Override
	public List<User> selectUserByPhones(String phone) {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserExample example=new UserExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<User> ulList = userMapper.selectByExample(example);
		if (ulList != null) {
			return ulList;
		}
		return null;
	}

}
