package com.taobaos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taobaos.json.ResultObject;
import com.taobaos.pojo.Activity;
import com.taobaos.service.ActivityService;

@Controller
@RequestMapping("/")
public class ActivityAction {
	@Autowired
	ActivityService activityService;
	
	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public void activity(ModelMap model, HttpServletRequest request) {

	}
	
	@RequestMapping(value = "/activity", method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ResultObject<String> activity(HttpServletRequest request,HttpServletResponse response) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		List<Activity> activity = null;
		if (name.equals("")) {
			activity = activityService.selectActivityAll();
		} else {
			activity = activityService.selectActivityByName(name);
		}
		if (activity == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("activity", activity);
			resultObject.setData("/taobaos/activity.htm");
		} else {
			resultObject.setMap("activity", activity);
			resultObject.setData("/taobaos/activity.htm");
		}
		return resultObject;
	}

}
