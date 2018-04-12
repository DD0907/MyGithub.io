package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Activity;
import com.taobaos.service.ActivityService;
import com.taobaos.serviceImpl.ActivityServiceImpl;

@WebServlet("/ActivityDeleteServlet")
public class ActivityDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ActivityService activityService = new ActivityServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "五一促銷";
		Activity activity = activityService.selectActivityByNames(name);
		if (activity == null) {
			response.getWriter().append("Served at:error,该活动不存在 ").append(request.getContextPath());
		} else {
			int result = activityService.deletestatusActivity(name);
			if (result > 0) {
				response.getWriter().append("Served at:success ").append(request.getContextPath());
			} else {
				response.getWriter().append("Served at:error").append(request.getContextPath());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
