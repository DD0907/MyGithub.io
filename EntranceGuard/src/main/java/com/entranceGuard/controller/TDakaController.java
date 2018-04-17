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
import com.entranceGuard.pojo.TDaka;
import com.entranceGuard.service.TDakaService;

@Controller
@RequestMapping("/")
public class TDakaController {
	@Autowired
	TDakaService tDakaService;

	@RequestMapping(value = "/tdaka", method = RequestMethod.GET)
	public void main(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/tdaka", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> main(HttpServletRequest request, HttpServletResponse response) {
		String stuid = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<TDaka> tDakas = null;
		if (stuid.equals("")) {
			tDakas = tDakaService.selectTDakaAll();
		} else {
			tDakas = tDakaService.selectTDakaByStuIds(stuid);
		}
		if (tDakas == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("tDaka", tDakas);
			resultObject.setData("/EntranceGuard/tdaka.htm");
		} else {
			resultObject.setResult("success");
			resultObject.setMessage("查询成功");
			resultObject.setMap("tDaka", tDakas);
			resultObject.setData("/EntranceGuard/tdaka.htm");
		}
		return resultObject;
	}
}