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
import com.taobaos.pojo.Shop;
import com.taobaos.service.ShopService;

@Controller
@RequestMapping("/")
public class ShopAction {
	@Autowired
	ShopService shopService;

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public void shop(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/shop", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> shop(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		List<Shop> shop = null;
		if (name.equals("")) {
			shop = shopService.selectShopAll();
		} else {
			shop = shopService.selectShopByName(name);
		}
		if (shop == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("shop", shop);
			resultObject.setData("/taobaos/shop.htm");
		} else {
			resultObject.setMap("shop", shop);
			resultObject.setData("/taobaos/shop.htm");
		}
		return resultObject;
	}
}
