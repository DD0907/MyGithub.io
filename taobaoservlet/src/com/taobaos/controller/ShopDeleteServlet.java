package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Shop;
import com.taobaos.service.ShopService;
import com.taobaos.serviceImpl.ShopServiceImpl;

/**
 * Servlet implementation class ShopDeleteServlet
 */
@WebServlet("/ShopDeleteServlet")
public class ShopDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShopService shopService = new ShopServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "微软";
		List<Shop> shop2 = shopService.selectShopByName(name);
		if (shop2 == null) {
			response.getWriter().append("Served at: error,店铺不存在").append(request.getContextPath());
			System.out.println("店铺不存在");
		} else {
			Shop shop = new Shop();
			shop.setName(name);
			int result = shopService.deleteShopStatus(shop);
			if (result > 0) {
				response.getWriter().append("Served at: success").append(request.getContextPath());
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
