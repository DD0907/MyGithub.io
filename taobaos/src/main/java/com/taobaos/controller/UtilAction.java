package com.taobaos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UtilAction {
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public void error(ModelMap model, HttpServletRequest request) {

	}
}
