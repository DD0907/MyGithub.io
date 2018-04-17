package com.entranceGuard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class TUserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String result = "success";
		String message = "登录成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		TLogin tLogin = userService.selectUserByUsername(username);
		HttpSession session = request.getSession();
		if (tLogin != null) {
			if (username.equals(tLogin.getUsername()) && password.equals(tLogin.getPassword())) {
				resultObject.setMap("tLogin", tLogin);
				resultObject.setData("/EntranceGuard/main.htm");
				session.setAttribute("username", username);
			} else {
				resultObject.setResult("error");
				resultObject.setMessage("登录失败");
				resultObject.setData("/EntranceGuard/login.htm");
			}
		} else {
			resultObject.setResult("errors");
			resultObject.setMessage("用户不存在");
			resultObject.setData("/EntranceGuard/error.htm");
		}
		return resultObject;
	}
	
	// 退出登录
		@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		@ResponseBody
		public ResultObject<String> logout(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			String result = "success";
			String message = "退出成功";
			ResultObject<String> resultObject = new ResultObject<>(result, message);
			session.removeAttribute("username");
			resultObject.setData("/EntranceGuard/login.htm");
			return resultObject;
		}
		
		// 注冊
		@RequestMapping(value = "/addUser", method = RequestMethod.GET)
		public void addUser(ModelMap model, HttpServletRequest request) {
		}

		@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
		@ResponseBody
		public ResultObject<String> addUser(HttpServletRequest request, HttpServletResponse response) {
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			String result = "success";
			String message = "用户添加成功";
			ResultObject<String> resultObject = new ResultObject<>(result, message);
			TLogin user = userService.selectUserByUsername(username);
			if (user != null) {
				resultObject.setResult("errors");
				resultObject.setMessage("用户已存在");
				resultObject.setData("/EntranceGuard/addUser.htm");
			} else {
				TLogin users = new TLogin();
				users.setUsername(username);
				users.setPassword(password);
				users.setIsuse("true");
				int index = userService.insertUser(users);
				if (index > 0) {
					resultObject.setData("/EntranceGuard/main.htm");
				} else {
					resultObject.setResult("error");
					resultObject.setMessage("用户添加失败");
					resultObject.setData("/EntranceGuard/addUser.htm");
				}
			}
			return resultObject;
		}
}
