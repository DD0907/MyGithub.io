package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.RolePermissionMapper;
import com.taobaos.pojo.RolePermission;
import com.taobaos.pojo.RolePermissionExample;
import com.taobaos.service.RolePermissionService;
import com.taobaos.util.DBUtil;

public class RolePermissionServiceImpl implements RolePermissionService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertRolePermission(RolePermission rolePermission) {
		RolePermissionMapper rolePermissionMapper = session.getMapper(RolePermissionMapper.class);
		int result = rolePermissionMapper.insertSelective(rolePermission);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateRolePermission(RolePermission rolePermission) {
		RolePermissionMapper rolePermissionMapper = session.getMapper(RolePermissionMapper.class);
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRoleIdEqualTo(rolePermission.getRoleId());
		int result = rolePermissionMapper.updateByExampleSelective(rolePermission, example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteRolePermission(RolePermission rolePermission) {
		RolePermissionMapper rolePermissionMapper = session.getMapper(RolePermissionMapper.class);
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andPermissionIdEqualTo(rolePermission.getPermissionId());
		int result = rolePermissionMapper.deleteByExample(example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<RolePermission> selectRolePermissionByRoleId(Integer roleId) {
		RolePermissionMapper rolePermissionMapper = session.getMapper(RolePermissionMapper.class);
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
		RolePermissionMapper rolePermissionMapper = session.getMapper(RolePermissionMapper.class);
		List<RolePermission> rolePermission = rolePermissionMapper.selectByExample(null);
		if (rolePermission.isEmpty()) {
			return null;
		}
		return rolePermission;
	}

}
