package com.entranceGuard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entranceGuard.json.ResultObject;
import com.entranceGuard.pojo.TLogin;
import com.entranceGuard.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/main", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> main(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<TLogin> users = null;
		if (username.equals("")) {
			users = userService.selectUserAll();
		} else {
			users = userService.selectUserByUsernames(username);
		}
		if (users==null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("user", users);
			resultObject.setData("/EntranceGuard/main.htm");
		} else {
			resultObject.setResult("success");
			resultObject.setMessage("查询成功");
			resultObject.setMap("user", users);
			resultObject.setData("/EntranceGuard/main.htm");
		}
		return resultObject;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public void error(ModelMap model, HttpServletRequest request) {

	}
}
