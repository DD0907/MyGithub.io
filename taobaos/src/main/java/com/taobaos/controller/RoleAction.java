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
import com.taobaos.pojo.Role;
import com.taobaos.service.RoleService;

@Controller
@RequestMapping("/")
public class RoleAction {
	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public void role(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/role", method = RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> role(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<Role> roles = null;
		if (name.equals("")) {
			roles = roleService.selectRoleAll();
		} else {
			roles = roleService.selectRoleByName(name);
		}
		if (roles == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("role", roles);
			resultObject.setData("/taobaos/role.htm");
		} else {
			resultObject.setMap("role", roles);
			resultObject.setData("/taobaos/role.htm");
		}
		return resultObject;
	}
	
	//添加角色
		@RequestMapping(value = "/addRole", method = RequestMethod.GET)
		public void addRole(ModelMap model, HttpServletRequest request) {

		}
		@RequestMapping(value="/addRole",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public ResultObject<String> addRole(HttpServletRequest request,HttpServletResponse response){
			String name = request.getParameter("name").trim();
			boolean status = Boolean.parseBoolean(request.getParameter("status").trim());
			String result = "success";
			String message = "添加成功";
			ResultObject<String> resultObject = new ResultObject<String>(result, message);
			Role roles = roleService.selectRoleByNameS(name);
			if (roles != null) {
				resultObject.setResult("errors");
				resultObject.setMessage("此角色已存在");
			resultObject.setData("/taobaos/role.htm");
			} else {
				Role role = new Role();
				role.setName(name);
				role.setStatus(status);
				int index = roleService.insertRole(role);
				if (index > 0) {
					resultObject.setData("/taobaos/role.htm");
				} else {
					resultObject.setResult("error");
					resultObject.setMessage("添加异常");
					resultObject.setData("/taobaos/role.htm");
				}
			}
			return resultObject;
		}
		
	
	//更改角色
	@RequestMapping(value = "/updateRole", method = RequestMethod.GET)
	public void updateRole(ModelMap model, HttpServletRequest request) {

	}
	@RequestMapping(value="/updateRole",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ResultObject<String> updateRole(HttpServletRequest request,HttpServletResponse response){
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name").trim();
		boolean status = Boolean.parseBoolean(request.getParameter("status").trim());
		String result = "success";
		String message = "修改成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
//		Role roles = roleService.selectRoleByNameS(name);
//		if (roles != null) {
//			resultObject.setResult("errors");
//			resultObject.setMessage("此角色已存在");
//			resultObject.setData("/taobaos/role.htm");
//		} else {
			Role role = new Role();
			role.setId(id);
			role.setName(name);
			role.setStatus(status);
			int index = roleService.updateRole(role);
			if (index > 0) {
				resultObject.setData("/taobaos/role.htm");
			} else {
				resultObject.setResult("error");
				resultObject.setMessage("修改异常");
				resultObject.setData("/taobaos/role.htm");
			}
	//	}
		return resultObject;
	}
	
	// 删除角色 更改角色状态
	@RequestMapping(value = "/deleteRole", method = RequestMethod.DELETE, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> deleteRole(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String result = "success";
		String message = "更改成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		Role roles = roleService.selectRoleById(id);
		Role role = new Role();
		role.setId(roles.getId());
		role.setName(roles.getName());
		role.setStatus(false);
		int index = roleService.deletestatusRole(role);
		if (index > 0) {
			resultObject.setData("/taobaos/role.htm");
		} else {
			resultObject.setResult("error");
			resultObject.setMessage("更改异常");
			resultObject.setData("/taobaos/role.htm");
		}
		return resultObject;
	}

}
