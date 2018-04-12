package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.RolePermissionMapper;
import com.taobaos.pojo.RolePermission;
import com.taobaos.pojo.RolePermissionExample;
import com.taobaos.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	@Override
	public int insertRolePermission(RolePermission rolePermission) {
		int result = rolePermissionMapper.insertSelective(rolePermission);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateRolePermission(RolePermission rolePermission) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRoleIdEqualTo(rolePermission.getRoleId());
		int result = rolePermissionMapper.updateByExampleSelective(rolePermission, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteRolePermission(RolePermission rolePermission) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andPermissionIdEqualTo(rolePermission.getPermissionId());
		int result = rolePermissionMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<RolePermission> selectRolePermissionByRoleId(Integer roleId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<RolePermission> rolePermission = rolePermissionMapper.selectByExample(example);
		if (rolePermission.isEmpty()) {
			return null;
		}
		return rolePermission;
	}

	@Override
	public List<RolePermission> selectRolePermissionAll() {
		List<RolePermission> rolePermission = rolePermissionMapper.selectByExample(null);
		if (rolePermission.isEmpty()) {
			return null;
		}
		return rolePermission;
	}

}
