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
import com.taobaos.pojo.Item;
import com.taobaos.service.ItemService;

@Controller
@RequestMapping("/")
public class ItemAction {
	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public void item(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/item", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public ResultObject<String> item(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		List<Item> item = null;
		if (name.equals("")) {
			item = itemService.selectItemAll();
		} else {
			item = itemService.selectItemByName(name);
		}
		if (item == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("item", item);
			resultObject.setData("/taobaos/item.htm");
		} else {
			resultObject.setMap("item", item);
			resultObject.setData("/taobaos/item.htm");
		}
		return resultObject;
	}

}
