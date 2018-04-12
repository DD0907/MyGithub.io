package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.PermissionMapper;
import com.taobaos.pojo.Permission;
import com.taobaos.pojo.PermissionExample;
import com.taobaos.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionMapper permissionMapper;

	@Override
	public int insertPermission(Permission permission) {
		int result = permissionMapper.insertSelective(permission);
		return result;
	}

	@Override
	public int updatePermission(Permission permission) {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andIdEqualTo(permission.getId());
		int result = permissionMapper.updateByExample(permission, example);
		return result;
	}

	@Override
	public int deletePermission(Permission permission) {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andNameEqualTo(permission.getName());
		int result = permissionMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deletestatusPermission(Permission permission) {
		int result = permissionMapper.deletestatusPermission(permission);
		return result;
	}

	@Override
	public Permission selectPermissionByName(String name) {
		Permission permission = permissionMapper.selectPermissionByName(name);
		if (permission != null) {
			return permission;
		}
		return null;
	}

	@Override
	public List<Permission> selectPermissionAll() {
		List<Permission> pList = permissionMapper.selectByExample(null);
		if (pList.isEmpty()) {
			return null;
		} else {
			return pList;
		}
	}

	@Override
	public List<Permission> selectPermissionByNames(String name) {
		PermissionExample example = new PermissionExample();
		example.createCriteria().andNameEqualTo(name);
		List<Permission> pList = permissionMapper.selectByExample(example);
		if (pList.isEmpty()) {
			return null;
		} else {
			return pList;
		}
	}

	@Override
	public Permission selectPermissionById(Integer id) {
		Permission permission = permissionMapper.selectByPrimaryKey(id);
		if (permission != null) {
			return permission;
		}
		return null;
	}

}
