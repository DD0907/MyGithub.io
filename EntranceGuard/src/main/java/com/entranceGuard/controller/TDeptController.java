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
import com.entranceGuard.pojo.TXibie;
import com.entranceGuard.service.TXiBieService;

@Controller
@RequestMapping("/")
public class TDeptController {
	@Autowired
	TXiBieService tDeptService;

	@RequestMapping(value = "/tdept", method = RequestMethod.GET)
	public void main(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/tdept", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> main(HttpServletRequest request, HttpServletResponse response) {
		String xibiename = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<TXibie> tXibies = null;
		if (xibiename.equals("")) {
			tXibies = tDeptService.selectByAll();
		} else {
			tXibies = tDeptService.selectByName(xibiename);
		}
		if (tXibies == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("tXibie", tXibies);
			resultObject.setData("/EntranceGuard/tdept.htm");
		} else {
			resultObject.setResult("success");
			resultObject.setMessage("查询成功");
			resultObject.setMap("tXibie", tXibies);
			resultObject.setData("/EntranceGuard/tdept.htm");
		}
		return resultObject;
	}
}
