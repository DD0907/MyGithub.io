package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.User;
import com.taobaos.service.UserService;
import com.taobaos.serviceImpl.UserServiceImpl;
import com.taobaos.util.MD5Util;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService adminUserService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = adminUserService.selectUserByPhone(phone);
		if (user == null) {
			response.getWriter().append("Served at: error,无此用户").append(request.getContextPath());
		} else if (user != null) {
			User user2 = new User();
			user2.setName(name);
			user2.setHashpassword(MD5Util.getMd5(password));
			user2.setSalt(password);
			user2.setPhone(phone);
			int result = adminUserService.updateUser(user2);
			if (result > 0) {
				request.getRequestDispatcher("/page/main.jsp").forward(request, response);
				// response.sendRedirect("page/main.jsp");
				// response.getWriter().append("Served at:
				// success,修改成功").append(request.getContextPath());
			} else {
				response.getWriter().append("Served at: error,修改失败").append(request.getContextPath());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
