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
import com.taobaos.pojo.User;
import com.taobaos.service.UserService;

@Controller
@RequestMapping("/")
public class MainAction {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/main", method = RequestMethod.POST)
	@ResponseBody
	public ResultObject<String> main(HttpServletRequest request, HttpServletResponse response) {
		String phone = request.getParameter("phone");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<User> users = null;
		if (phone.equals("")) {
			users = userService.selectUserAll();
		} else {
			users = userService.selectUserByPhones(phone);
		}
		if (users.isEmpty()) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("user", users);
			resultObject.setData("/taobaos/main.htm");
		} else {
			resultObject.setResult("success");
			resultObject.setMessage("查询成功");
			resultObject.setMap("user", users);
			resultObject.setData("/taobaos/main.htm");
		}
		return resultObject;
	}
}
