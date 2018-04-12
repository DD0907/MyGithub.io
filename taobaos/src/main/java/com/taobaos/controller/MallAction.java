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
import com.taobaos.pojo.Mall;
import com.taobaos.service.MallServie;

@Controller
@RequestMapping("/")
public class MallAction {
	@Autowired
	MallServie mallServie;

	@RequestMapping(value = "/mall", method = RequestMethod.GET)
	public void mall(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/mall", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> mall(HttpServletResponse response, HttpServletRequest request) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		List<Mall> mall = null;
		if (name.equals("")) {
			mall = mallServie.selectMallAll();
		} else {
			mall = mallServie.selectMallByName(name);
		}
		if (mall == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("mall", mall);
			resultObject.setData("/taobaos/mall.htm");
		} else {
			resultObject.setMap("mall", mall);
			resultObject.setData("/taobaos/mall.htm");
		}
		return resultObject;
	}
}
