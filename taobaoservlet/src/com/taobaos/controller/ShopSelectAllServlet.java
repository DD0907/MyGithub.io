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

@WebServlet("/ShopSelectAllServlet")
public class ShopSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShopService shopService = new ShopServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<Shop> shop = shopService.selectShopAll();
		if (shop.isEmpty()) {
			response.getWriter().append("Served at: error").append(request.getContextPath());
		} else {
//			response.getWriter().append("Served at:" + JSON.toJSONString(shop)).append(request.getContextPath());
//			System.out.println(JSON.toJSONString(shop));
			request.setAttribute("shop", shop);
			//将list数据发送到.jap文件中  
	        request.getRequestDispatcher("/page/shop.jsp").forward(request, response);  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
