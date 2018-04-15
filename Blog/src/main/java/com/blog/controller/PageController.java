package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void index(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public void blog(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/blogSingle", method = RequestMethod.GET)
	public void blogSingle(ModelMap model, HttpServletRequest request) {

	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public void contact(ModelMap model, HttpServletRequest request) {

	}
}
