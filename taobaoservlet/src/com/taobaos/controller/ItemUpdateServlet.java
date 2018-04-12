package com.taobaos.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Item;
import com.taobaos.service.ItemService;
import com.taobaos.serviceImpl.ItemServiceImpl;

@WebServlet("/ItemUpdateServlet")
public class ItemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemService itemService = new ItemServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String code = null;
		Integer shopId = null;
		String mainPic = null;
		String note = null;
		BigDecimal price = null;
		BigDecimal originPrice = null;
		Boolean status = false;
		Item item = itemService.selectItemByNames(name);
		if (item == null) {
			response.getWriter().append("Served at: error,暂无此商品").append(request.getContextPath());
		} else {
			Item items = new Item();
			items.setId(item.getId());
			items.setName(name);
			items.setCode(code);
			items.setMainPic(mainPic);
			items.setNote(note);
			items.setPrice(price);
			items.setOriginPrice(originPrice);
			items.setShopId(shopId);
			items.setStatus(status);
			itemService.updateItem(items);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
