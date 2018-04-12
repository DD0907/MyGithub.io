package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.User;
import com.taobaos.service.UserService;
import com.taobaos.serviceImpl.UserServiceImpl;

@WebServlet("/UserSelectAllServlet")
public class UserSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService adminUserService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String users=request.getParameter("users");
		if (users.equals("")||users.equals(null)) {
			List<User> user = adminUserService.selectUserAll();
			if (user == null) {
				response.getWriter().append("Served at: error").append(request.getContextPath());
				System.out.println("用户名不存在");
			} else if (user != null) {
				request.setAttribute("user", user);
				//将list数据发送到.jap文件中  
		        request.getRequestDispatcher("/page/main.jsp").forward(request, response);  
			}
		}else {
			List<User> user = adminUserService.selectUserByPhones(users);
			if (user == null) {
				response.getWriter().append("Served at: error").append(request.getContextPath());
				System.out.println("用户名不存在");
			} else if (user != null) {
				request.setAttribute("user", user);
				//将list数据发送到.jap文件中  
		        request.getRequestDispatcher("/page/main.jsp").forward(request, response);  
				//response.sendRedirect("page/main.jsp");
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
