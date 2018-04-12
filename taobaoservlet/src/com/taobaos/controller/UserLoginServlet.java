package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taobaos.pojo.User;
import com.taobaos.service.UserService;
import com.taobaos.serviceImpl.UserServiceImpl;
import com.taobaos.util.MD5Util;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService adminUserService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		User user = adminUserService.selectUserByPhone(phone);
		if (user != null) {
			// 对密码进行加密
			String md5Text = MD5Util.getMd5(password) + user.getSalt();
			// System.out.println(MD5Util.getMd5(password) + "," + password);
			if ((user.getHashpassword() + user.getSalt()).equals(md5Text) && phone.equals(user.getPhone())) {
				// response.getWriter().append("Served at: success" +
				// JSON.toJSONString(user))
				// .append(request.getContextPath());
				//
				session.setAttribute("phone", phone);
				System.out.println("登录成功");
				response.sendRedirect("page/main.jsp");
			} else {
				response.sendRedirect("page/login.jsp");
				System.out.println("用户名或密码错误");
			}
		} else {
			response.sendRedirect("page/404.jsp");
			response.getWriter().append("Served at: error").append(request.getContextPath());
		}
	}

}
