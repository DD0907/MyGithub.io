package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Item;
import com.taobaos.service.ItemService;
import com.taobaos.serviceImpl.ItemServiceImpl;

@WebServlet("/ItemSelectAllServlet")
public class ItemSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemService itemService = new ItemServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String items = request.getParameter("items");
		if (items.equals("") || items.equals(null)) {
			List<Item> items2 = itemService.selectItemAll();
			if (items2.isEmpty()) {
				response.getWriter().append("Served at: error,暂无此商品").append(request.getContextPath());
			} else {
				request.setAttribute("item", items2);
				request.getRequestDispatcher("/page/item.jsp").forward(request, response);
			}
		} else {
			List<Item> items2 = itemService.selectItemByName(items);
			if (items2 == null) {
				response.getWriter().append("Served at: error,暂无此商品").append(request.getContextPath());
			} else {
				request.setAttribute("item", items2);
				request.getRequestDispatcher("/page/item.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
