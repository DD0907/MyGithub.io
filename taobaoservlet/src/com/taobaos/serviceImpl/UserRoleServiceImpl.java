package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.UserRoleMapper;
import com.taobaos.pojo.UserRole;
import com.taobaos.pojo.UserRoleExample;
import com.taobaos.service.UserRoleService;
import com.taobaos.util.DBUtil;

public class UserRoleServiceImpl implements UserRoleService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertUserRole(UserRole userRole) {
		UserRoleMapper userRoleMapper = session.getMapper(UserRoleMapper.class);
		int result = userRoleMapper.insertSelective(userRole);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateUserRole(UserRole userRole) {
		UserRoleMapper userRoleMapper = session.getMapper(UserRoleMapper.class);
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserPhoneEqualTo(userRole.getUserPhone());
		int result = userRoleMapper.updateByExampleSelective(userRole, example);
		session.commit();
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
		UserRoleMapper userRoleMapper = session.getMapper(UserRoleMapper.class);
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
		UserRoleMapper userRoleMapper = session.getMapper(UserRoleMapper.class);
		List<UserRole> userRole = userRoleMapper.selectByExample(null);
		if (userRole.isEmpty()) {
			return null;
		}
		return userRole;
	}

}
