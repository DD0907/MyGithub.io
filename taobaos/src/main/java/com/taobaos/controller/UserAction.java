package com.taobaos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taobaos.json.ResultObject;
import com.taobaos.pojo.User;
import com.taobaos.service.UserService;
import com.taobaos.util.MD5Util;

@Controller
@RequestMapping("/")
public class UserAction {
	@Autowired
	UserService userService;

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(ModelMap model, HttpServletRequest request) {
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String phone = request.getParameter("phone").trim();
		String password = request.getParameter("password").trim();
		String result = "success";
		String message = "登录成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		User user = userService.selectUserByPhone(phone);
		if (user != null) {
			// 对密码进行加密
			String md5Text = MD5Util.getMd5(password) + user.getSalt();
			if ((user.getHashpassword() + user.getSalt()).equals(md5Text) && phone.equals(user.getPhone())) {
				session.setAttribute("phone", phone);
				// System.out.println("登录成功");
				resultObject.setData("/taobaos/main.htm");
			} else {
				resultObject.setResult("error");
				resultObject.setMessage("用户名或密码错误");
				resultObject.setData("/taobaos/login.htm");
				// System.out.println("用户名或密码错误");
			}
		} else {
			resultObject.setResult("errors");
			resultObject.setMessage("用户名不存在,请及时联系管理员");
			resultObject.setData("/taobaos/error.htm");
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
		// session.invalidate();
		session.removeAttribute("phone");
		resultObject.setData("/taobaos/login.htm");
		return resultObject;
	}

	// 注冊
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public void addUser(ModelMap model, HttpServletRequest request) {
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> addUser(HttpServletRequest request, HttpServletResponse response) {
		String phone = request.getParameter("phone").trim();
		String name = request.getParameter("name").trim();
		String password = request.getParameter("password").trim();
		String result = "success";
		String message = "用户添加成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		User user = userService.selectUserByPhone(phone);
		if (user != null) {
			resultObject.setResult("errors");
			resultObject.setMessage("用户已存在");
			resultObject.setData("/taobaos/addUser.htm");
		} else {
			User users = new User();
			users.setPhone(phone);
			users.setName(name);
			users.setHashpassword(MD5Util.getMd5(password));
			users.setSalt(password);
			int index = userService.insertUser(users);
			if (index > 0) {
				resultObject.setData("/taobaos/main.htm");
			} else {
				resultObject.setResult("error");
				resultObject.setMessage("用户添加失败");
				resultObject.setData("/taobaos/addUser.htm");
			}
		}
		return resultObject;
	}

	// 修改
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public void updateUser(ModelMap model, HttpServletRequest request) {
	}

	// 修改
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> updateUser(HttpServletResponse response, HttpServletRequest request) {
		String phone = request.getParameter("phone");
		String name = request.getParameter("name").trim();
		String password = request.getParameter("password").trim();
		String result = "success";
		String message = "修改成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		user.setSalt(password);
		user.setHashpassword(MD5Util.getMd5(password));
		int index = userService.updateUser(user);
		if (index > 0) {
			resultObject.setData("/taobaos/main.htm");
		} else {
			resultObject.setResult("error");
			resultObject.setMessage("修改异常");
			resultObject.setData("/taobaos/main.htm");
		}
		return resultObject;
	}
}
