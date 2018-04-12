package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.taobaos.pojo.Shop;
import com.taobaos.service.ShopService;
import com.taobaos.serviceImpl.ShopServiceImpl;

@WebServlet("/ShopInsertServlet")
public class ShopInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShopService shopService = new ShopServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");*/
		String name = "微商";
		String note = "测试";
		String url = "测试";
		String logUrl = "测试";
		List<Shop> shop2 = shopService.selectShopByName(name);
		System.out.println(JSON.toJSON(shop2));
		if (shop2 == null) {
			Shop shop = new Shop();
			shop.setName(name);
			shop.setLogUrl(logUrl);
			shop.setUrl(url);
			shop.setNote(note);
			shop.setStatus(true);
			int result = shopService.insertShop(shop);
			if (result > 0) {
				response.getWriter().append("Served at: success").append(request.getContextPath());
			} else {
				response.getWriter().append("Served at: error").append(request.getContextPath());
			}
		} else {
			response.getWriter().append("Served at: error,店铺已存在").append(request.getContextPath());
			System.out.println("店铺已存在");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
