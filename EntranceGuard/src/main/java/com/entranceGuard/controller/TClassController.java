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
import com.entranceGuard.pojo.TClass;
import com.entranceGuard.service.TClassService;

@Controller
@RequestMapping("/")
public class TClassController {
	@Autowired
	TClassService tClassService;

	@RequestMapping(value = "/tclass", method = RequestMethod.GET)
	public void main(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/tclass", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> main(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<TClass> tClasses = null;
		if (name.equals("")) {
			tClasses = tClassService.selectTClassAll();
		} else {
			tClasses = tClassService.selectTClassByclassNames(name);
		}
		if (tClasses == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("tClass", tClasses);
			resultObject.setData("/EntranceGuard/tclass.htm");
		} else {
			resultObject.setResult("success");
			resultObject.setMessage("查询成功");
			resultObject.setMap("tClass", tClasses);
			resultObject.setData("/EntranceGuard/tclass.htm");
		}
		return resultObject;
	}
}
