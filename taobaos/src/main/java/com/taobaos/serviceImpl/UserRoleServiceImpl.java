package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.UserRoleMapper;
import com.taobaos.pojo.UserRole;
import com.taobaos.pojo.UserRoleExample;
import com.taobaos.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	UserRoleMapper userRoleMapper;

	@Override
	public int insertUserRole(UserRole userRole) {
		int result = userRoleMapper.insertSelective(userRole);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateUserRole(UserRole userRole) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserPhoneEqualTo(userRole.getUserPhone());
		int result = userRoleMapper.updateByExampleSelective(userRole, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteUserRole(UserRole userRole) {

		return 0;
	}

	@Override
	public List<UserRole> selectUserRoleByPhone(String phone) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserPhoneEqualTo(phone);
		List<UserRole> userRole = userRoleMapper.selectByExample(example);
		if (userRole.isEmpty()) {
			return null;
		}
		return userRole;
	}

	@Override
	public List<UserRole> selectUserRoleAll() {
		List<UserRole> userRole = userRoleMapper.selectByExample(null);
		if (userRole.isEmpty()) {
			return null;
		}
		return userRole;
	}

}
