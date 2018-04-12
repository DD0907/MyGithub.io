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

@WebServlet("/UserRegServlet")
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService adminUserService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String name = request.getParameter("username");
		if (phone.equals("") && name.equals("")) {
			System.out.println("输入不为空");
			return;
		} else {
			// 密码和salt设为同一个值
			String salt = request.getParameter("password");
			User user = adminUserService.selectUserByPhone(phone);
			if (user != null) {
				response.getWriter().append("Served at: error,用户名已存在").append(request.getContextPath());
				System.out.println("用户名已存在");
			} else {
				user = new User();
				user.setPhone(phone);
				user.setName(name);
				user.setSalt(salt);
				user.setHashpassword(MD5Util.getMd5(salt));
				int i = adminUserService.insertUser(user);
				if (i > 0) {
					System.out.println("注册成功");
					response.sendRedirect("page/main.jsp");
//					System.out.println(i + ">>>>>>>>>>>>>>>>>>>");
//					response.getWriter().append("Served at: " + "success,注册成功").append(request.getContextPath());
				} else {
					response.sendRedirect("page/reg.jsp");
					// response.getWriter().append("Served at: " +
					// "error,注册失败").append(request.getContextPath());
					System.out.println("注册失败");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
