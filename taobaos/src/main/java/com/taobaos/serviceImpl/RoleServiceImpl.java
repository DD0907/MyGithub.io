package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.RoleMapper;
import com.taobaos.pojo.Role;
import com.taobaos.pojo.RoleExample;
import com.taobaos.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleMapper;

	@Override
	public int insertRole(Role role) {
		int result = roleMapper.insert(role);
		return result;
	}

	@Override
	public int updateRole(Role role) {
		RoleExample example = new RoleExample();
		example.createCriteria().andNameEqualTo(role.getName());
		int result = roleMapper.updateByExample(role, example);
		return result;
	}

	@Override
	public int deleteRole(Role role) {
		return 0;
	}

	@Override
	public List<Role> selectRoleByName(String name) {
		RoleExample example = new RoleExample();
		example.createCriteria().andNameEqualTo(name);
		List<Role> role = roleMapper.selectByExample(example);
		if (role.isEmpty()) {
			return null;
		}
		return role;
	}

	@Override
	public List<Role> selectRoleAll() {
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
		int result = roleMapper.deletestatusRole(role);
		return result;
	}

	@Override
	public Role selectRoleByNameS(String name) {
		Role role = roleMapper.selectRoleByNameS(name);
		if (role != null) {
			return role;
		}
		return null;
	}

	@Override
	public Role selectRoleById(Integer id) {
		Role role = roleMapper.selectByPrimaryKey(id);
		if (role != null) {
			return role;
		}
		return null;
	}
}
