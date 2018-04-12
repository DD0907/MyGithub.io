package com.taobaos.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.taobaos.pojo.Activity;
import com.taobaos.service.ActivityService;
import com.taobaos.serviceImpl.ActivityServiceImpl;

@WebServlet("/ActivityInsertServlet")
public class ActivityInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ActivityService activityService = new ActivityServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "新店开业";
		String note = "开业测试";
		String picUrl = "www.baifm.pic";
		Boolean status = true;
		Activity activity = activityService.selectActivityByNames(name);
		Date startTime = null;
		Date endTime = null;
		System.out.println(JSON.toJSON(activity));
		if (activity == null) {
			Activity activity2 = new Activity();
			activity2.setName(name);
			activity2.setNote(note);
			activity2.setPicUrl(picUrl);
			activity2.setStartTime(startTime);
			activity2.setEndTime(endTime);
			activity2.setStatus(status);
			int result = activityService.insertActivity(activity2);
			if (result > 0) {
				response.getWriter().append("Served at: success").append(request.getContextPath());
			} else {
				response.getWriter().append("Served at: error").append(request.getContextPath());
			}
		} else {
			response.getWriter().append("Served at: error,活动已存在").append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
