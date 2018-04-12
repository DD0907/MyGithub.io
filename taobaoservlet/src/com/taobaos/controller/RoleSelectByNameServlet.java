package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.taobaos.pojo.Role;
import com.taobaos.service.RoleService;
import com.taobaos.serviceImpl.RoleServiceImpl;

@WebServlet("/RoleSelectByNameServlet")
public class RoleSelectByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleService roleService = new RoleServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "经理";
		Role role = roleService.selectRoleByNameS(name);
		if (role == null) {
			response.getWriter().append("Served at:error,该角色不存在 ").append(request.getContextPath());
			System.out.println("该角色不存在");
		} else {
			response.getWriter().append("Served at:success " + JSON.toJSONString(role))
					.append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
