package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.taobaos.pojo.Shop;
import com.taobaos.service.ShopService;
import com.taobaos.serviceImpl.ShopServiceImpl;

@WebServlet("/ShopUpdateServlet")
public class ShopUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShopService shopService = new ShopServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "微软中国";
		Shop shop2 = shopService.updateSelectShopByName(name);
		System.out.println(JSON.toJSON(shop2));
		if (shop2 == null) {
			response.getWriter().append("Served at: error,店铺不存在").append(request.getContextPath());
			System.out.println("店铺不存在");
		} else {
			String note = "测试修改2";
			String url = "www.baidu.com";
			String logUrl = "测试";
			Boolean status = false;
			Shop shop = new Shop();
			shop.setId(shop2.getId());
			shop.setName(name);
			shop.setLogUrl(logUrl);
			shop.setUrl(url);
			shop.setNote(note);
			shop.setStatus(status);
			int result = shopService.updateShop(shop);
			if (result > 0) {
				response.getWriter().append("Served at: success"+JSON.toJSONString(shop)).append(request.getContextPath());
			} else {
				response.getWriter().append("Served at: error").append(request.getContextPath());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
