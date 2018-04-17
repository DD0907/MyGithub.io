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
import com.entranceGuard.pojo.TYuanqu;
import com.entranceGuard.service.TYuanquService;

@Controller
@RequestMapping("/")
public class TYuanquController {
	@Autowired
	TYuanquService tYuanquService;

	@RequestMapping(value = "/tyuanqu", method = RequestMethod.GET)
	public void main(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/tyuanqu", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> main(HttpServletRequest request, HttpServletResponse response) {
		String yuanquname = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<TYuanqu> tYuanqus = null;
		if (yuanquname.equals("")) {
			tYuanqus = tYuanquService.selectTYuanquAll();
		} else {
			tYuanqus = tYuanquService.selectTYuanquByIds(yuanquname);
		}
		if (tYuanqus == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("tyuanqu", tYuanqus);
			resultObject.setData("/EntranceGuard/tyuanqu.htm");
		} else {
			resultObject.setResult("success");
			resultObject.setMessage("查询成功");
			resultObject.setMap("tyuanqu", tYuanqus);
			resultObject.setData("/EntranceGuard/tyuanqu.htm");
		}
		return resultObject;
	}
}
