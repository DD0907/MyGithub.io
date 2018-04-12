package com.taobaos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taobaos.json.ResultObject;
import com.taobaos.pojo.Permission;
import com.taobaos.service.PermissionService;

@Controller
@RequestMapping("/")
public class PermissionAction {
	@Autowired
	PermissionService permissionService;

	@RequestMapping(value = "/permission", method = RequestMethod.GET)
	public void permission(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/permission", method = RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> permission(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<Permission> permissions = null;
		if (name.equals("")) {
			permissions = permissionService.selectPermissionAll();
		} else {
			permissions = permissionService.selectPermissionByNames(name);
		}
		if (permissions == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("permission", permissions);
			resultObject.setData("/taobaos/permission.htm");
		} else {
			resultObject.setMap("permission", permissions);
			resultObject.setData("/taobaos/permission.htm");
		}
		return resultObject;
	}

	@RequestMapping(value = "/updatePermission", method = RequestMethod.GET)
	public void updatePermission(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> updatePermission(HttpServletResponse response, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name").trim();
		boolean status = Boolean.parseBoolean(request.getParameter("status").trim());
		String result = "success";
		String message = "修改成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
//		Permission permissions = permissionService.selectPermissionByName(name);
//		if (permissions != null) {
//			resultObject.setResult("errors");
//			resultObject.setMessage("此权限已存在");
//			resultObject.setData("/taobaos/permission.htm");
//		} else {
			Permission permission = new Permission();
			permission.setId(id);
			permission.setName(name);
			permission.setStatus(status);
			int index = permissionService.updatePermission(permission);
			if (index > 0) {
				resultObject.setData("/taobaos/permission.htm");
			} else {
				resultObject.setResult("error");
				resultObject.setMessage("修改异常");
				resultObject.setData("/taobaos/permission.htm");
			}
//		}
		return resultObject;
	}
	
	
	@RequestMapping(value = "/addPermission", method = RequestMethod.GET)
	public void addPermission(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/addPermission", method = RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> addPermission(HttpServletResponse response, HttpServletRequest request) {
		String name = request.getParameter("name").trim();
		boolean status = Boolean.parseBoolean(request.getParameter("status").trim());
		String result = "success";
		String message = "添加成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		Permission permissions = permissionService.selectPermissionByName(name);
		if (permissions != null) {
			resultObject.setResult("errors");
			resultObject.setMessage("此权限已存在");
			resultObject.setData("/taobaos/permission.htm");
		} else {
			Permission permission = new Permission();
			permission.setName(name);
			permission.setStatus(status);
			int index = permissionService.insertPermission(permission);
			if (index > 0) {
				resultObject.setData("/taobaos/permission.htm");
			} else {
				resultObject.setResult("error");
				resultObject.setMessage("添加出现异常");
				resultObject.setData("/taobaos/permission.htm");
			}
		}
		return resultObject;
	}

	// 删除权限 更改权限状态
	@RequestMapping(value = "/deletePermission", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> deletePermission(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String result = "success";
		String message = "更改成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		Permission permissions = permissionService.selectPermissionById(id);
		Permission permission = new Permission();
		permission.setId(permissions.getId());
		permission.setName(permissions.getName());
		permission.setStatus(false);
		int index = permissionService.deletestatusPermission(permission);
		if (index > 0) {
			resultObject.setData("/taobaos/permission.htm");
		}else {
			resultObject.setResult("error");
			resultObject.setMessage("修改异常");
			resultObject.setData("/taobaos/permission.htm");
		}
		return resultObject;
	}
}
