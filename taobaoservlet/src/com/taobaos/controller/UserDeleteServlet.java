package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.taobaos.pojo.User;
import com.taobaos.service.UserService;
import com.taobaos.serviceImpl.UserServiceImpl;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService adminUserService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		JSONObject resultJSON = new JSONObject();
		User user = adminUserService.selectUserByPhone(phone);
		if (user != null) {
			user = new User();
			user.setPhone(phone);
			int i = adminUserService.deleteUser(user);
			if (i > 0) {
				resultJSON.put("status", "success");
				response.sendRedirect("page/main.jsp");
				System.out.println("删除成功");
			} else {
				response.sendRedirect("page/404.jsp");
				response.getWriter().append("Served at: " + "error,删除失败").append(request.getContextPath());
			}
		} else {
			response.getWriter().append("Served at: error,无此用户").append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
