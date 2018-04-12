package com.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.service.UserService;

@Controller
@RequestMapping("/")
public class PageAction {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void index(ModelMap model, HttpServletRequest request) {
		/*User userDo=new User();
		userDo.setName("123456");
		userDo.setPassword("123456");
		User testUser = userService.getUser(userDo);
		System.out.println(testUser);*/
		
	}

}
