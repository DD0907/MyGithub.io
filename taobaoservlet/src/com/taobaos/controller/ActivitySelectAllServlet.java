package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Activity;
import com.taobaos.service.ActivityService;
import com.taobaos.serviceImpl.ActivityServiceImpl;

@WebServlet("/ActivitySelectAllServlet")
public class ActivitySelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ActivityService activityService = new ActivityServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<Activity> aList = activityService.selectActivityAll();
		if (aList == null) {
			response.getWriter().append("Served at: error,暂无此活动").append(request.getContextPath());
		} else {
			request.setAttribute("activity", aList);
			//将list数据发送到.jap文件中  
	        request.getRequestDispatcher("/page/activity.jsp").forward(request, response);
			//response.getWriter().append("Served at:" + JSON.toJSONString(aList)).append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
