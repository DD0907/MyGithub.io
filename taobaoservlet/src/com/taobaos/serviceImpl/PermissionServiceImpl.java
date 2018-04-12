package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.PermissionMapper;
import com.taobaos.pojo.Permission;
import com.taobaos.pojo.PermissionExample;
import com.taobaos.service.PermissionService;
import com.taobaos.util.DBUtil;

public class PermissionServiceImpl implements PermissionService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertPermission(Permission permission) {
		PermissionMapper permissionMapper = session.getMapper(PermissionMapper.class);
		int result = permissionMapper.insert(permission);
		session.commit();
		return result;
	}

	@Override
	public int updatePermission(Permission permission) {
		PermissionMapper permissionMapper = session.getMapper(PermissionMapper.class);
		PermissionExample example = new PermissionExample();
		example.createCriteria().andNameEqualTo(permission.getName());
		int result = permissionMapper.updateByExample(permission, example);
		session.commit();
		return result;
	}

	@Override
	public int deletePermission(Permission permission) {
		PermissionMapper permissionMapper = session.getMapper(PermissionMapper.class);
		PermissionExample example=new PermissionExample();
		example.createCriteria().andNameEqualTo(permission.getName());
		int result=permissionMapper.deleteByExample(example);
		session.commit();
		if (result>0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deletestatusPermission(Permission permission) {
		PermissionMapper permissionMapper = session.getMapper(PermissionMapper.class);
		int result = permissionMapper.deletestatusPermission(permission);
		session.commit();
		return result;
	}

	@Override
	public Permission selectPermissionByName(String name) {
		PermissionMapper permissionMapper = session.getMapper(PermissionMapper.class);
		Permission permission = permissionMapper.selectPermissionByName(name);
		if (permission != null) {
			return permission;
		}
		return null;
	}

	@Override
	public List<Permission> selectPermissionAll() {
		PermissionMapper permissionMapper = session.getMapper(PermissionMapper.class);
		List<Permission> pList = permissionMapper.selectByExample(null);
		if (pList.isEmpty()) {
			return null;
		} else {
			return pList;
		}
	}

}
