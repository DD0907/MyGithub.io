package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Mall;
import com.taobaos.service.MallServie;
import com.taobaos.serviceImpl.MallServiceImpl;

@WebServlet("/MallSelectAllServlet")
public class MallSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MallServie mallServie = new MallServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<Mall> malls = mallServie.selectMallAll();
		if (malls.isEmpty()) {
			response.getWriter().append("Served at: error,暂无商城").append(request.getContextPath());
		} else {
//			response.getWriter().append("Served at:" + JSON.toJSONString(malls)).append(request.getContextPath());
//			System.out.println(JSON.toJSONString(malls));
			request.setAttribute("mall", malls);
			//将list数据发送到.jap文件中  
	        request.getRequestDispatcher("/page/mall.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
