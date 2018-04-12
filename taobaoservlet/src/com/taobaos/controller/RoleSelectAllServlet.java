package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Role;
import com.taobaos.service.RoleService;
import com.taobaos.serviceImpl.RoleServiceImpl;

@WebServlet("/RoleSelectAllServlet")
public class RoleSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleService roleService = new RoleServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String role = request.getParameter("roles");
		if (role.equals("") || role.equals(null)) {
			List<Role> roles = roleService.selectRoleAll();
			if (roles == null) {
				response.getWriter().append("Served at: error,赞无角色").append(request.getContextPath());
			} else {
				request.setAttribute("role", roles);
				request.getRequestDispatcher("/page/role.jsp").forward(request, response);
			}
		} else {
			List<Role> roles = roleService.selectRoleByName(role);
			if (roles == null) {
				response.getWriter().append("Served at: error,赞无角色").append(request.getContextPath());
			} else {
				request.setAttribute("role", roles);
				request.getRequestDispatcher("/page/role.jsp").forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
