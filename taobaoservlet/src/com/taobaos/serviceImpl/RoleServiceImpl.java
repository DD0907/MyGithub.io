package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.RoleMapper;
import com.taobaos.pojo.Role;
import com.taobaos.pojo.RoleExample;
import com.taobaos.service.RoleService;
import com.taobaos.util.DBUtil;

public class RoleServiceImpl implements RoleService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertRole(Role role) {
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		int result = roleMapper.insert(role);
		session.commit();
		return result;
	}

	@Override
	public int updateRole(Role role) {
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		RoleExample example = new RoleExample();
		example.createCriteria().andNameEqualTo(role.getName());
		int result = roleMapper.updateByExample(role, example);
		session.commit();
		return result;
	}

	@Override
	public int deleteRole(Role role) {
		return 0;
	}

	@Override
	public List<Role> selectRoleByName(String name) {
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		RoleExample example = new RoleExample();
		example.createCriteria().andNameEqualTo(name);
		List<Role> role = roleMapper.selectByExample(example);
		if (role != null) {
			return role;
		}
		return null;
	}

	@Override
	public List<Role> selectRoleAll() {
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		List<Role> rList = roleMapper.selectByExample(null);
		if (rList.isEmpty()) {
			return null;
		} else {
			return rList;
		}
	}

	// 将status改为0即为删除状态
	@Override
	public int deletestatusRole(Role role) {
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		int result = roleMapper.deletestatusRole(role);
		session.commit();
		return result;
	}

	@Override
	public Role selectRoleByNameS(String name) {
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		Role role = roleMapper.selectRoleByNameS(name);
		if (role != null) {
			return role;
		}
		return null;
	}
}
