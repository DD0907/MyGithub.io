package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Permission;
import com.taobaos.service.PermissionService;
import com.taobaos.serviceImpl.PermissionServiceImpl;

@WebServlet("/PermissionSelectAllServlet")
public class PermissionSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PermissionService permissionService=new PermissionServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<Permission> permissions=permissionService.selectPermissionAll();
		if (permissions.isEmpty()) {
			response.getWriter().append("Served at: 暂无权限名").append(request.getContextPath());
		}else {
			request.setAttribute("permission", permissions);
			request.getRequestDispatcher("/page/permission.jsp").forward(request, response);
//			response.getWriter().append("Served at: Success"+JSON.toJSONString(permissions)).append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
