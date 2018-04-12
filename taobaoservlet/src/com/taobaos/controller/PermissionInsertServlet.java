package com.taobaos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Permission;
import com.taobaos.service.PermissionService;
import com.taobaos.serviceImpl.PermissionServiceImpl;

@WebServlet("/PermissionInsertServlet")
public class PermissionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PermissionService permissionService = new PermissionServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "超级管理员";
		Boolean status = true;
		Permission permission = permissionService.selectPermissionByName(name);
		if (permission == null) {
			Permission permission2 = new Permission();
			permission2.setName(name);
			permission2.setStatus(status);
			int result = permissionService.insertPermission(permission2);
			if (result > 0) {
				response.getWriter().append("Served at:success").append(request.getContextPath());
			} else {
				response.getWriter().append("Served at:error").append(request.getContextPath());
			}
		} else {
			response.getWriter().append("Served at: 权限名已存在").append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}