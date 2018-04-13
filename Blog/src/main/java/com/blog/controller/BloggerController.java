package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.json.ResultObject;
import com.blog.pojo.Blogger;
import com.blog.service.BloggerService;

@Controller
@RequestMapping("/data")
public class BloggerController {
	@Autowired
	BloggerService bloggerService;

	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> index(HttpServletRequest request, HttpServletResponse response) {
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		Blogger t = new Blogger();
		t.setId(1);
		List<Blogger> bloggers = bloggerService.selectBloggerAll();
		resultObject.setMap("bloggers", bloggers);
		if (bloggers == null) {
			System.out.println(".............................>>>>>>>>>>>>");
		} else {
			System.out.println("111111111111111111111111111111111111111111");
		}
		return resultObject;
	}
}
