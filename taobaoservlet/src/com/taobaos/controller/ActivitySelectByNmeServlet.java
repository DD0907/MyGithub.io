package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.taobaos.pojo.Activity;
import com.taobaos.service.ActivityService;
import com.taobaos.serviceImpl.ActivityServiceImpl;

@WebServlet("/ActivitySelectByNmeServlet")
public class ActivitySelectByNmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ActivityService activityService = new ActivityServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "五一促銷";
		List<Activity> aList = activityService.selectActivityByName(name);
		if (aList == null) {
			response.getWriter().append("Served at: error,暂无此活动").append(request.getContextPath());
		} else {
			response.getWriter().append("Served at:" + JSON.toJSONString(aList)).append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
